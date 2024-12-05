package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.PlayerConstants.GetSpriteAmount;
import static utilz.Constants.PlayerConstants.IDLE;

public class Player extends Entity {

    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 25;
    private int playerAction = IDLE;
    private boolean moving = false;
    private boolean attacking = false;
    private boolean left, up, right, down;
    private float playerSpeed = 2.0f;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {
        updateAnimationTick();
        setAnimation();
        updatePos();
    }

    public void render(Graphics g) {
        g.drawImage(
                animations[playerAction][aniIndex],
                (int) x,
                (int) y,
                256,
                160,
                null);
    }

    public void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
                attacking = false;
            }
        }
    }

    public void setAnimation() {
        int startAni = playerAction;
        if (moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }

        if (attacking){
            playerAction = ATTACK_1;
        }
        if (startAni != playerAction) {
            resetAniTick();
        }
    }

    public void resetAniTick(){
        aniTick = 0;
        aniIndex = 0;
    }

    public void updatePos(){
        moving = false;
        if (left && !right){
            x -= playerSpeed;
            moving = true;
        }else if(right && !left){
            x += playerSpeed;
            moving = true;
        }
        if (up && !down){
            y -= playerSpeed;
            moving = true;
        }
        if (down && !up){
            y += playerSpeed;
        }
    }

    private void loadAnimations() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            BufferedImage img = ImageIO.read(is);

            animations = new BufferedImage[9][6];
            for (int row = 0; row < animations.length; row++)
                for (int col = 0; col < animations[row].length; col++)
                    animations[row][col] = img.getSubimage(col * 64, row * 40, 64, 40);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void resetDirBooleans(){
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setAttacking(boolean attacking){
        this.attacking = attacking;
    }

    public boolean isLeft(){
        return left;
    }

    public void setLeft(boolean left){
        this.left = left;
    }
    // TODO: repeat for Up, Down, Right for previous 2


}

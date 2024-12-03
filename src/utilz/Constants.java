package utilz;

public class Constants {

    public static class Directions {
        // TODO: Note:  All of these are public, static, and final
        public static final int LEFT = 0;
        public static final int UP = 1;
        // TODO: create an int named UP and initialize to 1.
        // TODO: create an int named RIGHT and initialize to 2.
        // TODO: create an int named DOWN and initialize to 3.
    }

    public static class PlayerConstants {
        // TODO: Note:  All of these are public static, and final.
        public static final int IDLE = 0;
        // TODO: create an int named RUNNING and initialize to 1.
        // TODO: create an int named JUMP and initialize to 2.
        // TODO: create an int named FALLING and initialize to 3.
        // TODO: create an int named GROUND and initialize to 4.
        // TODO: create an int named HIT and initialize to 5.
        // TODO: create an int named ATTACK_1 and initialize to 6.
        // TODO: create an int named ATTACK_JUMP_1 and initialize to 7.
        // TODO: create an int named ATTACK_JUMP_2 and initialize to 8.

        public static int GetSpriteAmount(int player_action) {
            switch (player_action) {
                case RUNNING:
                    return 6;
                case IDLE:
                    return 5;
                case HIT:
                    return 4;
                case JUMP:
                case ATTACK_1:
                case ATTACK_JUMP_1:
                case ATTACK_JUMP_2:
                    return 3;
                case GROUND:
                    return 2;
                case FALLING:
                default:
                    return 1;
            }
        }
    }
}

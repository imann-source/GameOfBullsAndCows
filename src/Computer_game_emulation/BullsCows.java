package Computer_game_emulation;

public class BullsCows {


    public static String getBullsCows(int i, int j) {
        String bullsCows = null;
            if (i == 1) {
                bullsCows = i + " корова ";
                System.out.printf("%d корова ", i);
            } else if (i > 1 && i < 5) {
                bullsCows = i + " коровы ";
                System.out.printf("%d коровы ", i);
            } else if (i > 5 && i < 11 || i == 0) {
                bullsCows = i + " коров ";
                System.out.printf("%d коров ", i);
            }

            if (j == 1) {
                bullsCows = bullsCows + j + " бык ";
                System.out.printf("%d бык\n", j);
            } else if (j > 1 && j < 5) {
                bullsCows = bullsCows + j + " быка ";
                System.out.printf("%d быка\n", j);
            } else if (j > 5 && j < 11 || j == 0) {
                bullsCows = bullsCows + j + " быков ";
                System.out.printf("%d быков\n", j);
            }
            if (i == 0 && j == 0) {
                bullsCows = "0 коров 0 быков";
            }

        return bullsCows;
    }
}





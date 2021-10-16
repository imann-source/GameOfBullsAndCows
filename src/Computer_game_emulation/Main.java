package Computer_game_emulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static Computer_game_emulation.ReadWriteResult.*;


public class Main {

    public static void main(String[] args) throws IOException {
        final int max = 9;
        int level;
        int count = 1;
        int bulls = 0;
        int cows = 0;
        String option = null;
        int countGame = 1;
        int minusNumberCount = 0;
        String result = "./src/Computer_game_emulation/Result.txt";
        List<Integer> minusNumber = new ArrayList<Integer>();

        Rules();                                                                    //Правила игры
        countGame = ReadCreateFile(result, countGame);
        System.out.print("Прошу ввести уровень сложности (от 1 до 10 уровня): ");
        Scanner levelIn = new Scanner(System.in);
        while ((level = levelIn.nextInt()) < 0 || level >= 10) {
            System.out.println("Пожалуйста введи корректные данные! От 1 до 10!");
        }
        System.out.println("Прошу загадать и ввести числа: ");

        Scanner numbersIn = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= level; i++) {
            numbers.add(numbersIn.nextInt());
        }

        CreateGame(result, countGame, String.valueOf(numbers));
        while (!(bulls == level)) {
            bulls = 0;
            cows = 0;

            List<Integer> randNumbers = new ArrayList<Integer>();
            for (int i = 1; i <= level; i++) {
                randNumbers.add(rnd(max));
                for (int j = 1; j <= minusNumberCount; j++) {
                    System.out.println(minusNumber.get(j - 1));

                    if (randNumbers.get(i + 1).equals(minusNumber.get(j))) {
                        randNumbers.remove(i);

                    }
                    //           System.out.println(randNumbers.get(i));
                }
            }


                for (int i = 0; i <= level - 1; i++) {
                    for (int j = 0; j <= level - 1; j++) {
                        if (randNumbers.get(i) == numbers.get(j) && i != j) {
                            cows++;
                        }
                        if (randNumbers.get(i) == numbers.get(j) && i == j) {
                            bulls++;
                        }
                    }
                }
                CreateRequest(result, String.valueOf(randNumbers), cows, bulls);

                if (bulls == level) {
                    break;
                } else {
                    count++;
                    if (bulls == 0 && cows == 0) {
                        for (int i = 0; i <= level - 1; i++) {
                            minusNumber.add(randNumbers.get(i));
                            minusNumberCount++;
                        }
                    }
                }
            }
            CreateFinal(result, count, bulls, level);
            if (bulls == level) {
                System.out.printf("Компьютер нашел всех бычков за %d раз!\n", count);
            }
        }

        private static int rnd ( int i){
//
//        for (int j = 1; i <= 9; i++) {
//            rand.add(i);
            return (int) (Math.random() * i);

        }

        private static void Rules () throws FileNotFoundException {
            Scanner input = new Scanner(new File("./src/Computer_game_emulation/Rules_of_the_game.txt"));
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
        }

    private void showUniqueRandomElements(int j, int k) {
        var list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        int randomInt = list.get(random);

        if (j == 1) {
            list.remove(k);
            j--;
        }
        return randomInt;
    }

}

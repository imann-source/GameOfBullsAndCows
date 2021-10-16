package Intuition_game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Intuition_game.ReadWriteResult.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final int max = 9;
        int level;
        int count = 1;
        int bulls = 0;
        int cows = 0;
        String option = null;
        int countGame = 1;
        String result = "./src/Intuition_game/Result.txt";

        Rules();                                                                    //Правила игры
        countGame = ReadCreateFile(result,countGame);
        System.out.print("Прошу ввести уровень сложности (от 1 до 10 уровня): ");
        Scanner levelIn = new Scanner(System.in);
        while ((level = levelIn.nextInt()) < 0 || level >= 10) {
                System.out.println("Пожалуйста введи корректные данные! От 1 до 10!");
            }

            List<Integer> randNumbers = new ArrayList<Integer>();
            for (int i = 1; i <= level; i++) {
                randNumbers.add(rnd(max));
            }
            System.out.println(randNumbers);
            CreateGame (result, countGame, String.valueOf(randNumbers));
            while (!(bulls == level)) {
            bulls =0;
            cows = 0;
            System.out.println("Прошу ввести числа: ");

            Scanner numbersIn = new Scanner(System.in);

            List<Integer> numbers = new ArrayList<Integer>();
            for (int i = 1; i <= level; i++) {
                numbers.add(numbersIn.nextInt());
            }

            for (int i = 0; i <= level - 1; i++) {
                for (int j = 0; j <= level - 1; j++) {
                    if (numbers.get(i) == randNumbers.get(j) && i != j) {
                        cows++;
                    }
                    if (numbers.get(i) == randNumbers.get(j) && i == j) {
                        bulls++;
                    }
                }
            }

            CreateRequest (result, String.valueOf(numbers), cows, bulls);

            if (bulls == level){
                break;
            } else {
                System.out.print("Попробуем ещё раз? Да/Нет: ");
                Scanner continueOrEnd = new Scanner(System.in);

                while (!((option = continueOrEnd.next()).equals("да") || option.equals("Да") || option.equals("нет") || option.equals("Нет"))) {
                    System.out.println("Пожалуйста введите либо \"Да\", либо \"Нет\"");
                }
                if (option.equals("нет") || option.equals("Нет")) {
                    break;
                }
                count++;
            }
        }
        CreateFinal(result,count,bulls, level);
        if (bulls == level){
            System.out.printf("Поздравляю Вас! Вы нашли всех бычков с %d раза!\n", count);
        }
        if (bulls != level){
            System.out.printf ("Не отчаивайтесь!В следующий раз точно повезет!\nЗагадываемое число было: %s\n",randNumbers);
        }
    }
    private static int rnd (int max) {
        return (int) (Math.random() * max);
    }

    private static void Rules () throws FileNotFoundException {
        Scanner input = new Scanner(new File("./src/Intuition_game/Rules_of_the_game.txt"));
        while (input.hasNextLine()) {
            System.out.println(input.nextLine());
        }
    }


}



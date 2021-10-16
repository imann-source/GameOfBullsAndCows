package Computer_game_emulation;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import static Intuition_game.BullsCows.getBullsCows;

public class ReadWriteResult {

    protected static int ReadCreateFile(String i, int j) throws IOException {

        try {
            FileReader readFile = new FileReader(i);
            Scanner scan = new Scanner(readFile);
            while (scan.hasNext()) {
                if (scan.findInLine("Game") != null) {
                    j++;
                }
                scan.nextLine();
            }
            readFile.close();
            return j;
        } catch (Exception e) {
            File file = new File(i);
            file.createNewFile();
        }

        return j;
    }
    protected static void CreateGame (String i, int j, String k) throws IOException {
            FileWriter CreateGame = new FileWriter(i, true);
            PrintWriter out = new PrintWriter(CreateGame);
            out.printf("Game №%d %2$td %2$tm %2$tY %2$tH:%2$tM Загаданная строка %3$s\n", j, new Date(), k);
            out.flush();
            out.close();
            CreateGame.close();
    }
    protected static void CreateRequest (String i, String j,int k, int l) throws IOException {
        FileWriter CreateRequest = new FileWriter(i, true);
        PrintWriter out = new PrintWriter(CreateRequest);
        out.printf("    Запрос: %s Ответ: %s\n", j, getBullsCows(k,l));
        out.flush();
        out.close();
        CreateRequest.close();
    }
    protected static void CreateFinal (String i, int j,int k,int l) throws IOException {
        FileWriter CreateFinal = new FileWriter(i, true);
        PrintWriter out = new PrintWriter(CreateFinal);
        if (k == l) {
            out.printf("    Строка была угадана за %d раз.\n", j);
        }
        out.flush();
        out.close();
        CreateFinal.close();
    }

}




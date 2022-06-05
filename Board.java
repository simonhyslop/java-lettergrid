import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Board {
    private static final String INPUT_FILE_PATH = "letters.in";
    private ArrayList<Die> allTheDice = new ArrayList<>();
    public static Random generator;

    public static void main(String[] args) {
        generator = new Random();
        Board fullBoard = new Board(INPUT_FILE_PATH);
        System.out.println(fullBoard.printBoard());
    }
    
    public Board(String inputFilePath) {
        try {
            Scanner scanner = new Scanner(new File(inputFilePath));
            while (scanner.hasNextLine()) {
                allTheDice.add(new Die(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    private void shuffleOrder() {
        Collections.shuffle(allTheDice);
        return;
    }

    public String printBoard() {
        shuffleOrder();

        String horizontalBorder = " -------------- ";

        StringBuffer boardString = new StringBuffer(horizontalBorder);

        for (int i = 0; i < allTheDice.size(); i++) {
            if(i % 4 == 0) {
                boardString.append("\n| ");
            }

            Die currentDie = allTheDice.get(i);
            boardString.append(" " + currentDie.getRandomLetter() + " ");

            if (i % 4 == 3) {
                boardString.append(" |");
            }

        }

        boardString.append("\n" + horizontalBorder);

        return boardString.toString();
    }

}

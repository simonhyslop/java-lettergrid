import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Board {
    private static final String INPUT_FILE_PATH = "letters.in";
    private ArrayList<Die> allTheDice = new ArrayList<>();

    public static void main(String[] args) {
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

    private void roll() {
        Collections.shuffle(this.allTheDice);
        return;
    }

    public String printBoard() {
        String horizontalBorder = " -------------- ";

        StringBuffer boardString = new StringBuffer(horizontalBorder);

        for (int i = 0; i < this.allTheDice.size(); i++) {
            if(i % 4 == 0) {
                boardString.append("\n| ");
            }

            Die currentDie = this.allTheDice.get(i);
            Collections.shuffle(currentDie.allLetters);
            boardString.append(" " + currentDie.allLetters.get(0) + " ");

            if (i % 4 == 3) {
                boardString.append(" |");
            }

        }

        boardString.append("\n" + horizontalBorder);

        return boardString.toString();
    }

}
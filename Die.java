import java.util.ArrayList;

public class Die {
    private char[] allLetters;

    public Die(String letterInput) {
        int numLetters = letterInput.length();
        allLetters = new char[numLetters];

        for (int i = 0; i < numLetters; i++) {
            allLetters[i] = letterInput.charAt(i);
        }
    }

    public char getRandomLetter() {
        int randomIndex = Board.generator.nextInt(allLetters.length);
        return allLetters[randomIndex];
    }

}

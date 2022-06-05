import java.util.ArrayList;

public class Die {
    private char[] allLetters;
    private char currLetter;

    public Die(String letterInput) {
        int numLetters = letterInput.length();
        allLetters = new char[numLetters];

        for (int i = 0; i < numLetters; i++) {
            allLetters[i] = letterInput.charAt(i);
        }

        this.roll();
    }

    public void roll() {
        int randomIndex = Board.generator.nextInt(allLetters.length);
        currLetter = allLetters[randomIndex];
    }

    public char getLetter() {
        return this.currLetter;
    }

}
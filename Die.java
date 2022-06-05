import java.util.ArrayList;

public class Die {
    public ArrayList<Character> allLetters = new ArrayList<>();

    public Die(String letterInput) {
        for (int i = 0; i < letterInput.length(); i++) {
            this.allLetters.add(letterInput.charAt(i));
        }
    }

}
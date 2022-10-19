import java.util.ArrayList;

/**
 * A word can have up to 7 letters
 * @author Laurence Lamarche-Cliche 101173070
 * @version 0.0
 */

public class Word {
    private ArrayList<Letter> letters;
    private int score;
    //

    public Word(ArrayList<Letter> letters, ArrayList<Integer> premium){
        this.letters = new ArrayList<Letter>(letters);
        //add a way to set premium tiles to letters
        //setLetterPremium using the premium array. 
    }

    /**
     * This method adds a given letter at a given position.
     * This can be used when a player adds a letter at the beginning or at the end of an existing word
     */
    public void addLetter(int position, Letter letter){
        this.letters.add(position, letter);
    }

    public ArrayList<Letter> getLetters(){
        return this.letters;
    }

    public void computeScore(){
        score = 0; // this is what becca will implement? How to score a word?
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    /**
     * The following is just for testing the Word and Letter classes.
     * Should be removed eventually and replaced by the appropriate automated tests.
     *
     * @author Laurence Lamarche-Cliche 101173070
     * @version 0.0
     */
    public static void main(String[] args) {
        Letter L = new Letter(Letter.Character.L);
        Letter O = new Letter(Letter.Character.O);
        Letter K = new Letter(Letter.Character.K);
        ArrayList<Letter> letters = new ArrayList<>();
        letters.add(L);
        letters.add(O);
        letters.add(L);

        Word word = new Word(letters);
        word.addLetter(word.getLetters().size(),K);
        for (Letter letter : word.getLetters()) {
            System.out.println(letter.toString() + " " + letter.getScore());
        }

    }


}

package Model;

import java.util.ArrayList;

/**
 * A word can have up to 7 letters
 *
 * @author Laurence Lamarche-Cliche 101173070
 * @version 3.0
 */

public class Word {
    private ArrayList<Letter> letters;
    private ArrayList<String> premiums; // these two arrays will always have the same length
    private int score;
    private int startingRow;
    private int startingCol;
    private int direction;


    // Only used for testing
    public Word(String word) {
        letters = new ArrayList<Letter>();
        for (int i = 0; i < word.length(); i++) {
            letters.add(new Letter(word.charAt(i)));
        }
        this.letters = new ArrayList<Letter>(letters);
        this.premiums = new ArrayList<String>();
        for (int i = 0; i < this.letters.size(); i++) {
            premiums.add("NONE");
        } // this populates the premium array with NONE's by default
        // this will eventually need to change
    }

    public Word(ArrayList<Letter> letters) {
        this.letters = new ArrayList<Letter>(letters);
        this.premiums = new ArrayList<String>();
        for (int i = 0; i < this.letters.size(); i++) {
            premiums.add("NONE");
        } // this populates the premium array with NONE's by default
        // this will eventually need to change
    }

    // TODO: add a constructor that takes a 2D array [Letter A, tuple (row, col)]
    // this constructor will need to
    // 1) Determine the direction based on which coordinate is changing, set the direction for the Word
    // 2) Create the Word with the previous constructor (adds NONE as premiums for now as default)
    // 3) Set coordinates for each letter
    // 4) Set premium for each letter

    /**
     * This method creates a new word and assigns premium tiles to certain letters.
     * The premiums are represented by an array of Strings that represent the
     * premium.
     * The letters without a premium must be associated with a "NONE" String.
     * For example, if one wishes to have the word HOWL, and have the W on a TL
     * premium (x3),
     * one must call the constructor this way:
     * Word([H, O, W, L], ["NONE", "NONE", "TL", "NONE"])
     * Where H, O, W and L are Letter objects.
     */
    public Word(ArrayList<Letter> letters, ArrayList<String> premiums) {
        this.letters = new ArrayList<Letter>(letters);
        this.premiums = new ArrayList<String>(premiums);
        for (int i = 0; i < this.letters.size(); i++) {
            letters.get(i).setPremium(premiums.get(i)); // set the premium for each letter to the corresponding String
        }
    }

    /**
     * This method adds a given letter at a given position.
     * This can be used when a player adds a letter at the beginning or at the end
     * of an existing word
     * If the letter than one wishes to add is not on a premium tile, premium shall
     * be input as 1.
     */
    public void addLetter(int position, Letter letter, String premium) {
        this.letters.add(position, letter);
        this.premiums.add(position, premium);
    }

    public ArrayList<Letter> getLetters() {
        return this.letters;
    }

    public ArrayList<String> getPremiums() {
        return this.premiums;
    }

    public int getScore() {
        return score;
    }

    public void setStartingCoordinates(int startingRow, int startingCol){
        this.startingRow = startingRow;
        this.startingCol = startingCol;
    }

    public int getStartingRow(){
        return this.startingRow;
    }

    /**
     * @param direction is 0 for a horizontal word and 1 for a vertical word
     */
    public void setDirection(int direction){
        this.direction = direction;
    }

    public int getDirection() {
        return this.direction;
    }

    @Override
    public String toString() {
        StringBuilder word = null;
        word = new StringBuilder();
        for (Letter letter : this.letters) {
            word.append(letter.toString());
        }
        return word.toString();
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
        Letter L1 = new Letter(Letter.Character.L);
        ArrayList<Letter> letters = new ArrayList<>();
        letters.add(L);
        letters.add(O);
        letters.add(L1);

        Word wordLetters = new Word(letters);
        Word wordString = new Word("legal");
        wordLetters.addLetter(wordLetters.getLetters().size(), K, "NONE");
        System.out.println(wordLetters.toString());
        System.out.println(wordString.toString());
        Bag letterBag = new Bag();
        Hand newHand = new Hand();
        newHand.drawFromBag(7);
        System.out.println(newHand);
        newHand.drawFromBag(2);
        System.out.println(newHand);
    }

}
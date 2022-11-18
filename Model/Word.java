package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * A word can have up to 7 letters
 *
 * @author Laurence Lamarche-Cliche 101173070
 * @version 3.0
 */

public class Word {
    private ArrayList<Letter> letters;
    private int score;
    private int startingRow;
    private int startingCol;
    private int direction;

    private final int RIGHT = 0;
    private final int DOWN = 1;
    private final int INVALID = -1;

    /*
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
     */

    public Word(ArrayList<Letter> letters) {
        this.letters = new ArrayList<Letter>(letters);
        sortLetters(letters);
        setDirection(letters);
        setStartingCoordinates();
    }

    /**
     * This method creates a new word and assigns premium tiles to certain letters.
     * The letters without a premium must be associated with a "NONE" String.
     * For example, if one wishes to have the word HOWL, and have the W on a TL
     * premium (x3),
     * one must call the constructor this way:
     * Word([H, O, W, L], ["NONE", "NONE", "TL", "NONE"])
     * Where H, O, W and L are Letter objects.
     */
    public Word(ArrayList<Letter> letters, ArrayList<String> premiums) {
        this.letters = new ArrayList<Letter>(letters);
        sortLetters(letters);
        for (int i = 0; i < this.letters.size(); i++) {
            letters.get(i).setPremium(premiums.get(i)); // set the premium for each letter to the corresponding String
        }
        setDirection(letters);
        setStartingCoordinates();

    }

    // TODO: add a constructor that takes a 2D array [Letter A, tuple (row, col)]
    // this constructor will need to
    // 1) Determine the direction based on which coordinate is changing, set the direction for the Word
    // 2) Create the Word with the previous constructor (adds NONE as premiums for now as default)
    // 3) Set coordinates for each letter
    // 4) Set premium for each letter

    private void sortLetters(ArrayList<Letter> letters){
        ArrayList<Letter> newLetters;
        if (this.direction == RIGHT) {
            Collections.sort(letters, Comparator.comparing(Letter::getCol));
        }
        else if (this.direction == DOWN) {
            Collections.sort(letters, Comparator.comparing(Letter::getRow));
        }
    }

    private void setDirection(ArrayList<Letter> letters){
        int countCOL = 0;
        int countROW = 0;

        ArrayList<Integer> cols = new ArrayList<Integer>();
        for (Letter letter : letters){
            cols.add(letter.getCol());
        }
        Collections.sort(cols);

        ArrayList<Integer> rows = new ArrayList<Integer>();
        for (Letter letter : letters){
            rows.add(letter.getRow());
        }
        Collections.sort(rows);

        int prevCol = -1;
        for (int col : cols) {
            if (col != prevCol) {
                countCOL += 1;
            }
            prevCol = col;
        }

        int prevRow = -1;
        for (int row : rows) {
            if (row != prevRow) {
                countROW += 1;
            }
            prevCol = row;
        }

        if (countROW > 1 && countCOL > 1) { this.direction = INVALID; }
        else if (countROW == 1 && countCOL > 1) { this.direction = RIGHT; }
        else if (countROW > 1 && countCOL == 1) { this.direction = DOWN; }
    }

    /**
     * This method adds a given letter at a given position.
     * This can be used when a player adds a letter at the beginning or at the end
     * of an existing word
     * If the letter than one wishes to add is not on a premium tile, premium shall
     * be input as 1.
     */
    public void addLetter(int position, Letter letter, String premium) {      // Can we take this out?
        this.letters.add(position, letter);
    }

    public ArrayList<Letter> getLetters() {
        return this.letters;
    }

    public int getScore() {
        return score;
    }

    public void setStartingCoordinates(){
        this.startingRow = (letters.get(0)).getRow();
        this.startingCol = (letters.get(0)).getCol();
    }

    public int getStartingRow(){
        return this.startingRow;
    }

    public int getStartingCol(){
        return this.startingCol;
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

}
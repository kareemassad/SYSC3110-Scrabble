package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A word can have up to 7 letters
 * @author Laurence Lamarche-Cliche 101173070 & Becca Young 101183297
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


    public Word(ArrayList<Letter> letters) {
        this.letters = letters;
        //setDirection(letters);
        setDirection(letters);
        sortLetters(letters);
        setStartingCoordinates();
        this.letters = new ArrayList<Letter>(letters);
    }


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
        boolean rowChanging = false;
        boolean colChanging = false;
        //TODO add a check for if size is 1. Need to count other letters to see direction.

        //assuming size is at least 2
        for (int i = 0; i < 1; i++){
            if (letters.get(i).getRow() != letters.get(i+1).getRow()){
                rowChanging = true;
            }
            if (letters.get(i).getCol() != letters.get(i+1).getCol()){
                colChanging = true;
            }
            if (rowChanging == colChanging){
                this.direction = INVALID; // invalid
            }
            else if (rowChanging){
                this.direction = DOWN;
            }
            else if (colChanging){
                this.direction = RIGHT;
            }
        }
    }

    /**
     * This method adds a given letter at a given position.
     * This can be used when a player adds a letter at the beginning or at the end
     * of an existing word
     * If the letter than one wishes to add is not on a premium tile, premium shall
     * be input as 1.
     */
    public void addLetter(int position, Letter letter) {      // Can we take this out?
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
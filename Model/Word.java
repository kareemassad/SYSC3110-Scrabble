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
        setStartingCoordinates(); // I don't think we need this anymore
        addAdjoiningLetter();
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
        //TODO add a check for if size is 1. Need to find the direction using other letters location.

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

    private ArrayList<Integer> checkForHole(int direction){
        boolean isHole = false;
        ArrayList<Integer> holeToFill = new ArrayList<Integer>();
        if (direction == 0) {
            for (int i = 0; i < letters.size()-1; i++) {
                if (letters.get(i).getCol() != letters.get(i + 1).getCol() + 1) {
                    holeToFill.add(0, i + 1); // the index in the WORD where a letter is missing
                    holeToFill.add(1, letters.get(i).getRow()); // the row with the letters
                    holeToFill.add(2, letters.get(i).getCol()+1); // the column where there is a hole
                    // H A *B* S - B is not in word.
                    // H(0).getCol = 0, A(1).getCol = 1, S(2).getCol = 3
                    // I shall add at index 2
                }
            }
        } else { // direction is down
            for (int i = 0; i < letters.size()-1; i++) {
                if (letters.get(i).getRow() != letters.get(i + 1).getRow() + 1) {
                    holeToFill.add(0, i + 1); // the index in the WORD where a letter is missing
                    holeToFill.add(1, letters.get(i).getRow()+1); // the row where there is a hole
                    holeToFill.add(2, letters.get(i).getCol()); // the column with all the other letters
                }
            }
        }
        return holeToFill; // TODO verify that this is size 0 if it does not enter the if statements
    }

    public void addAdjoiningLetter(){
        ArrayList<Integer> holeToFill = checkForHole(direction); //
        if (holeToFill.size() > 0) { // there is a hole, fill it with the letter
            addLetter(holeToFill.get(0), ScrabbleGame.getLetter(holeToFill.get(1), holeToFill.get(2)));
            // add the letter (get it from the model) at the given index position
        }
        else { // there is no hole
            // TODO: need to add the one at the end or at the beginning
        }

    }


    /**
     * This method adds a given letter at a given position.
     * This can be used when a player adds a letter at the beginning or at the end
     * of an existing word
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
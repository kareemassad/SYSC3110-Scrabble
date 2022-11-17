package Model;
/*
This class acts as a placeholder for how class Legality will work after restructuring other classes.
 */
/**
 * This class acts as a placeholder for how class Legality will work after restructuring other classes.
 *
 * @author Becca Young
 * @version 3.0
 */

import java.util.ArrayList;
import java.util.HashSet;

public class Legality2 {

    private Word word;
    private ArrayList<Word> attachedWords;
    private Board board;

    private HashSet<String> legal_words = new HashSet<String>();
    private final String file_path = "Words/english_words.txt";

    private final int RIGHT = 0;
    private final int DOWN = 1;
    private final int INVALID = -1;

    //private ArrayList<Integer> coord;          in Letter class
    //private ArrayList<Integer> startCoord;     in Word class
    //private int dir;                           in Word class

    public Legality2(Word word){
        this.word = word;
        this.attachedWords.add(word);
        addAttachedWords();
    }

    /**
     * This methods adds any attached words to the list
     * @author Laurence Lamarche-Cliche
     */
    private void addAttachedWords() {
        // assuming the board is a 2D array of Letters

        if (word.getDirection() == DOWN) { // cycle through each letter of the word

            for (Letter letter : word.getLetters()) { // the word is vertical, we look for attached words on sides (col +-
                int row = letter.getRow();
                int column = letter.getCol();
                int newWordColumn = letter.getCol(); // will hold the starting column for the new word
                int newWordLength = 0; // will hold the size of the new word

                if (letter.getCol() == RIGHT) { // only check to the right
                    while ((board.get_board()[row][column + 1].toString() != " ")) {
                        newWordLength++; // h
                        column++;
                    }
                } else if (letter.getCol() == 14) { //only check left
                    while ((board.get_board()[row][column - 1].toString() != " ")) {
                        newWordColumn--;
                        column--;
                        newWordLength++;
                    }
                } else if ((board.get_board()[row][column - 1].toString() != " ") &&
                        (board.get_board()[row][column + 1].toString() != " ")) { // nothing right or left
                    break; // break out of for loop and go to next letter
                } else { // I have letters left OR right, find beginning of word
                    while ((board.get_board()[row][column - 1].toString() != " ") || (column > 0)) { // there is a word there, find start
                        newWordColumn--;
                        column--;
                    } // now column points to the start of the word :), iterate right to find the end
                    while ((board.get_board()[row][column + 1].toString() != " ") || (column < 14)) {
                        newWordLength++;
                        column++;
                    } // now, newWordLength points the last index of the letter
                }

                if (newWordLength > 0) { // there is a word to add!
                    // create the array with all the letters in this word
                    ArrayList<Letter> newWordLetters = new ArrayList<Letter>();
                    for (int i = 0; i < newWordLength; i++) {
                        newWordLetters.add(board.get_board()[row][newWordColumn + i]);
                        // these letters already hold their premiums and all
                    }
                    Word newWord = new Word(newWordLetters);
                    this.attachedWords.add(newWord);
                }
            }
        }
        else { // word is horizontal, we look for attached word up and down (row+-)
            for (Letter letter : word.getLetters()) { // the word is vertical, we look for attached words on rows (row +-
                int row = letter.getRow();
                int column = letter.getCol();
                int newWordRow = letter.getRow(); // will hold the starting column for the new word
                int newWordLength = 0; // will hold the size of the new word

                if (letter.getRow() == 0) { // only check below
                    while ((board.get_board()[row + 1][column].toString() != " ")) {
                        newWordLength++; // h
                        row++;
                    }
                } else if (letter.getRow() == 14) { //only check above
                    while ((board.get_board()[row - 1][column].toString() != " ")) {
                        newWordRow--;
                        row--;
                        newWordLength++;
                    }
                } else if ((board.get_board()[row - 1][column].toString() != " ") &&
                        (board.get_board()[row + 1][column].toString() != " ")) { // nothing above or below
                    break; // break out of for loop and go to next letter
                }
                else { // I have letters up OR down, find beginning of word (up)
                    while ((board.get_board()[row - 1][column].toString() != " ") || (row > 0)) { // there is a word there, find start
                        newWordRow--;
                        row--;
                    } // now row points to the start of the word :), iterate down to find the end
                    while ((board.get_board()[row + 1][column].toString() != " ") || (row < 14)) {
                        newWordLength++;
                        row++;
                    } // now, newWordLength points the last index of the letter
                }

                if (newWordLength > 0) { // there is a word to add for that row!
                    // create the array with all the letters in this word
                    ArrayList<Letter> newWordLetters = new ArrayList<Letter>();
                    for (int i = 0; i < newWordLength; i++) {
                        newWordLetters.add(board.get_board()[newWordRow + i][column]);
                        // these letters already hold their premiums and all
                    }
                    Word newWord = new Word(newWordLetters);
                    this.attachedWords.add(newWord);
                }
            }
        }
    }

    // checks only if the word is a real word
    private boolean checkSingleWord(Word word) {
        if (legal_words.contains(word.toString())){
            return true;
        }
        return false;
    }

    // checks that all words, current word and all attached words, are real words
    private boolean checkAllWords() {
        for(Word word : attachedWords) {
            if(!checkSingleWord(word) || word.getDirection() == INVALID){
                return false;
            }
        }
        return true;
    }

    // checks that play is legal
    public boolean checkLegality(){
        if (checkAllWords() && attachedWords.size() > 1) {          // more than one because of Scrabble rule
            return true;
        }
        return false;
    }
}
/*
This class acts as a placeholder for how class Legality will work after restructuring other classes.
 */

import java.util.ArrayList;
import java.util.HashSet;

public class Legality2 {

    private Word word;
    private ArrayList<Word> attachedWords;

    private HashSet<String> legal_words = new HashSet<String>();
    private String file_path = "Words/english_words.txt";

    // private ArrayList<Integer> coord; in Letter class
    // private ArrayList<Integer> startCoord; in Word class
    // private int dir; in Word class

    public Legality2(Word word) {
        this.word = word;
        this.attachedWords.add(word);
        addAttachedWords();
    }

    // adds any attached words to the list.
    private void addAttachedWords() {
        // TODO: check with board, cycle through tiles in word to find adjacent tiles to
        // add

    }

    // checks only if the word is a real word
    private boolean checkSingleWord(Word word) {
        if (legal_words.contains(word.toString())) {
            return true;
        }
        return false;
    }

    // checks that all words, current word and all attached words, are real words
    private boolean checkAllWords() {
        for (Word word : attachedWords) {
            if (!checkSingleWord(word)) {
                return false;
            }
        }
        return true;
    }

    // checks that play is legal
    public boolean checkLegality() {
        if (checkAllWords() && attachedWords.size() > 1) { // more than one because of Scrabble rule
            return true;
        }
        return false;
    }
}

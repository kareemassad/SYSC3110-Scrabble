/*
Class Score is in charge of calculating and updating the score of a player
 */

// TODO needs to add score of all adjoining words

import java.util.ArrayList;

public class Score {
    private int wordScore = 0;
    private final Word word;

    public Score(Word word) {
        this.word = word;
        this.wordScore = calculateWord(word);
    }

    /* Returns the total score of a word played.
     *
     * @author Becca Young 101183297
     * @return wordScore the total score of a word played
     */
    public int getWordScore() {
        return this.wordScore;
    }

    /* Calculates the score of a word played
     *
     * @author Becca Young 101183297
     * @return the score of the word played in the location it was played.
     */
    private int calculateWord(Word word) {
        int score = 0;
        boolean DW = false;
        boolean TW = false;
        ArrayList<Letter> letters = word.getLetters();

        for(Letter letter: letters) {
            int letterVal = letter.getValue();
            String premium = letter.getPremium();

            switch (premium) {
                case "DL" -> letterVal *= 2;
                case "TL" -> letterVal *= 3;
                case "DW" -> DW = true;
                case "TW" -> TW = true;
            }
            score += letterVal;
        }
        if (DW){
            score *= 2;
        }
        else if (TW){
            score *= 3;
        }

        return score;
    }
}

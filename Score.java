// /*
// Class Score is in charge of calculating and updating the score of a player
// */

// // TODO needs to add score of all adjoining words

// import java.util.ArrayList;

// public class Score {
// private int wordScore = 0;
// private final Word word;

<<<<<<< HEAD
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
=======
// public Score(Word word) {
// this.word = word;
// calculateWord();
// }

// /* Returns the total score of a word played.
// *
// * @author Becca Young 101183297
// * @return wordScore the total score of a word played
// */
// public int getTotalScore() {
// calculateWord();
// return wordScore;
// }

// /* Adds the score of a word played to the total score of a player
// *
// * @author Becca Young 101183297
// */
// public void addTurnScore(Player player){ // To be used in class Game
// calculateWord();
// player.setScore(new Score(word));
// }

// /* Calculates the score of a word played
// *
// * @author Becca Young 101183297
// */
// private void calculateWord() {
// this.wordScore = 0;
// ArrayList<Letter> letters = word.getLetters();

// // need a way to assign whether a letter is on a premium ... Go in board?
// Word? Letter? New class ????
// // method getPremuium(letter)

// // This part may be delegated to wherever getPremium is
// String NONE, DL, TL, DW, TW;
// NONE = "None";
// DL = "Double Letter";
// TL = "Triple Letter";
// DW = "Double Word";
// TW = "Triple Word";

// for (Letter letter : letters) {
// String premium = letter.getPremium();
// this.wordScore += letter.getScore();

// if (premium.equals(DL)) {
// this.wordScore += letter.getScore();
// }
// else if (premium.equals(TL)) {
// this.wordScore += 2 * letter.getScore();
// }
// else if (premium.equals(DW)) {
// this.wordScore *= 2;
// }
// else if (premium.equals(TW)) {
// this.wordScore *= 3;
// }
// if (!premium.equals(NONE)) {
// board.removePremium(); // Premuium goes away after first use.
// }
// }
// }
// }
>>>>>>> c2a8525c5d3b17fd76614b466af43eb5d5e6566a

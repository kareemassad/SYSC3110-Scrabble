/*
Class Score is in charge of calculating and updating the score of a player
 */

public class Score {
    private int totalScore = 0;
    public int wordScore = 0;

    public int getTotalScore() {
        return totalScore;
    }

    public void addTurnScore(){
        calculateWord();

        // for all newly created words
            // calculateWord();

        totalScore += wordScore;
    }

    public void adjustPremiums(String input){

        String NONE, DL, TL, DW, TW;
        NONE = "None";
        DL = "Double Letter";
        TL = "Triple Letter";
        DW = "Double Word";
        TW = "Triple Word";

        for (char (letter.c) : input) {
            String premium = getPremium(letter); // don't know where this would go, likely board or letter

            if (premium.equals(DL)) {
                this.wordScore += letter.getValue();
            }
            else if (premium.equals(TL)) {
                this.wordScore += 2 * letter.getValue();
            }
            else if (premium.equals(DW)) {
                this.wordScore *= 2;
            }
            else if (premium.equals(TW)) {
                this.wordScore *= 3;
            }
            if (!premium.equals(NONE)) {
                board.removePremium();
            }


        }

        // for letters in word
            // if letter is on double letter
                // add letter value to wordScore
                // removePremium();
            // if letter is on triple letter
                // add 2 * letter value to wordScore
                 // removePremium();
            // if letter is on double word
                // multiply wordScore by 2
                // removePremium();
            // if letter is on triple word
                // multiply wordScore by 3
                // removePremium();
    }

    public void calculateWord() {
        int wordScore = 0;
        // for letter in word
            // add letter value to word Score

        adjustPremiums();
    }
}

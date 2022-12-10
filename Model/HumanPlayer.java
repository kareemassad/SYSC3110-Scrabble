package Model;

import java.util.ArrayList;

import View.Player;

/**
 * This class is the Player, responsible for holding his score and its letters
 *
 * @author Becca Young
 * @version 3.0
 */
public class HumanPlayer implements Player {
    private String handString;
    private ArrayList<Letter> handLetters;
    private int score;
    private int player_ID; // might be useful in Model.Game

    public HumanPlayer(int player_ID) {
        this.player_ID = player_ID;
        this.score = 0;
        setHand();
    }

    public int getScore() {
        return this.score;
    }

    public int getID() {
        return this.player_ID;
    }

    public String getHandString() {
        return this.handString;
    }

    public ArrayList<Letter> getHandLetters() {
        return this.handLetters;
    }

    // set the letters in the player's hand
    private void setHand() {
        this.handLetters = Bag.drawLetters(7); // set the initial bag content
        handToString();
    }

    // set the letters in the player's
    private void handToString() {
        StringBuilder s = new StringBuilder();
        for (Letter letter : this.handLetters) {
            s.append(letter.toString() + " ");
        }
        this.handString = s.toString();
    }

    public void removeFromHand(String letterToRemove) {
        letterToRemove.toUpperCase();
        for (int i = 0; i < this.handLetters.size(); i++) {
            if (letterToRemove.equals(this.handLetters.get(i).toString())) {
                this.handLetters.remove(i);
                handToString();
                return;
            }
        }
        handToString();
    }

    // check this because these letters need to be placed back in bag
    public void exchangeTiles() {
        for (Letter letter : this.handLetters) {
            removeFromHand(letter.toString());
        }
        setHand(); // set a new hand
    }

    public void addToHand(int numLettersToAdd) {
        if (this.handLetters.size() + numLettersToAdd > 7) {
            return;
        } else {
            ArrayList<Letter> lettersToAdd = Bag.drawLetters(numLettersToAdd);
            for (Letter letter : lettersToAdd) {
                this.handLetters.add(letter);
            }
        }
        handToString();
    }

    public void addToScore(Word word) {
        Score turnScore = new Score(word);
        this.score += turnScore.getWordScore();
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }
}
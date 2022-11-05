import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Keefer Belanger 101152085
 * @author Laurence Lamarche-Cliche 101173070
 * @version 0.2
 */

public class Hand {
    private HashSet<Letter> letters;

    public Hand() {
        this.letters = new HashSet<Letter>();
        // This could also be initialized with 7 letters to start if we prefer
    }

    /**
     * This draws the requested number of letters from the Bag and adds them to the
     * existing hand
     * This should be called with numLetters = 7 when the Hand is empty.
     */
    public void drawFromBag(Integer numLetters) {
        if (this.letters.size() == 0) {
            this.letters = Bag.drawLetters(numLetters);
        } else if ((this.letters.size() + numLetters) > 8) {
            System.out.println("you are requesting to draw more letters than you can have");
        } else {
            this.letters.addAll(Bag.drawLetters(numLetters));
        }
    }

    /**
     * This removes the requested letter from the Hand (when it is played, it should
     * no remain in the hand).
     * If two identical letters are present, this will only remove one occurence of
     * the letter.
     * Calling removeFromHand("A") on a Hand containing INEWAAT will result in the
     * hand becoming INEWAT
     * Only one letter can be removed at a time with this method.
     */
    public void removeFromHand(String letterToRemove) {
        letterToRemove.toUpperCase();
        for (Letter letter: this.letters){
            if (letterToRemove.equals(letter.toString())){
                this.letters.remove(letter);
            }
        }
    }

    // needed for Player
    public String toString() {
        StringBuilder hand = null;
        hand = new StringBuilder();
        for (Letter letter : this.letters) {
            hand.append(letter.toString());
        }
        return hand.toString();
    }

    // set hand method
    // public void setHand(ArrayList<Letter> letters) {
    // this.letters = letters;
    // }

}
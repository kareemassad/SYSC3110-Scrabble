import java.util.ArrayList;

/**
 *
 * @author Keefer Belanger 101152085
 * @author Laurence Lamarche-Cliche 101173070
 * @version 0.2
 */

public class Hand {
    private ArrayList<Letter> hand;

    public Hand() {
        this.hand = new ArrayList<Letter>();
        // This could also be initialized with 7 letters to start if we prefer
    }

    /**
     * This draws the requested number of letters from the Bag and adds them to the
     * existing hand
     * This should be called with numLetters = 7 when the Hand is empty.
     */
    public void drawFromBag(Integer numLetters) {
        if (this.hand.size() == 0) {
            this.hand = Bag.drawLetters(numLetters);
        } else if ((this.hand.size() + numLetters) > 8) {
            System.out.println("you are requesting to draw more letters than you can have");
        } else {
            this.hand.addAll(Bag.drawLetters(numLetters));
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
        for (int i = 0; i < this.hand.size(); i++) {
            if (letterToRemove.equals(this.hand.get(i).toString())) {
                this.hand.remove(i);
            }
        }
    }

    public ArrayList<Letter> getHand() {
        return this.hand;
    }

    // needed for Player
    public String toString() {
        StringBuilder hand = null;
        hand = new StringBuilder();
        for (Letter letter : this.hand) {
            hand.append(letter.toString());
        }
        return hand.toString();
    }

    // set hand method
    // public void setHand(ArrayList<Letter> letters) {
    // this.letters = letters;
    // }

}
import java.util.ArrayList;

/**
 *
 * @author Keefer Belanger 101152085
 * @author Laurence Lamarche-Cliche 101173070
 * @version 0.2
 */

public class Hand{
    private ArrayList<Letter> letters;

    public Hand(){
        this.letters = new ArrayList<Letter>();
        //This could also be initialized with 7 letters to start if we prefer
    }
    /**
     * This draws the requested number of letters from the Bag and adds them to the existing hand
     * This should be called with numLetters = 7 when the Hand is empty.
     */
    public void drawFromBag(Integer numLetters){
        if (this.letters.size() == 0) {
            this.letters = Bag.drawLetters(numLetters);
        }
        else if ((this.letters.size() + numLetters) > 7){
            System.out.println("you are requesting to draw more letters than you can have");
        }
        else {
            this.letters.addAll(Bag.drawLetters(numLetters));
        }
    }

    // needed for Player
    public String toString() {
        StringBuilder hand = null;
        hand = new StringBuilder();
        for (Letter letter: this.letters) {
            hand.append(letter.toString());
        }
        return hand.toString();
    }

}

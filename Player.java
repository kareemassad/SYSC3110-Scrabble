import java.util.ArrayList;

/*
Class Player is in charge of all details pertaining to a player, including their hand, score, etc.
 */

// TODO update hand

public class Player {
    private Hand hand;
    private int score;
    private String name;

    private int player_ID; // might be useful in Game

    public Player(int player_ID) {
        this.player_ID = player_ID;
        this.hand = new Hand();
        this.score = 0;
    }

    /*
     * Creates a player description in the format to be printed, with elements name,
     * score, and hand to print at start
     * of player turn.
     *
     * @author Becca Young 101183297
     * 
     * @param player is the player which the description is created for.
     * @return s is the string created of the player description.
     */
    public String playerDescription(Player player) {
        String s = new String("Player ID: " + player.player_ID + "\n Score: " + player.score
                + "\n Tiles: " + player.hand.toString() + "\n");
        return s;
    }

    public int getScore() {
        return this.score;
    }

    public Hand getHand() {
        return this.hand;
    }

    // set hand method
    public void setHand(int num_letters) {
        this.hand.drawFromBag(num_letters);
    }

    public void remove_from_hand(String letter) {
        this.hand.removeFromHand(letter);
    }

    public void add_to_hand(int words_to_replace) {
        this.hand.drawFromBag(words_to_replace);
    }

    public void addScore(Word word){
        Score turnScore = new Score(word);
        this.score += turnScore.getWordScore();
    }
}
/*
Class Player is in charge of all details pertaining to a player, including their hand, score, etc.
 */

// TODO update hand

public class Player {
    private Hand hand;
    private int score;
    private String name;

    public int playerID; // might be useful in Game


    /* Updates the score
     *
     * @author Becca Young 101183297
     */
    public void setScore(Score score) {
        this.score = score.getTotalScore();
    }

    /* Creates a player description in the format to be printed, with elements name, score, and hand to print at start
     * of player turn.
     *
     * @author Becca Young 101183297
     * @param player is the player which the description is created for.
     * @return s is the string created of the player description.
     */
    public String playerDescription(Player player) {
        String s = new String("Player: " + player.name + "\nScore: " + player.score
                + "\n Tiles: " + player.hand.toString() + "\n");
        return s;
    }

    /*
     * Plays a word, under player so that score is updated for player according to play.
     */
    /*
    public void playWord() {
        String input = new String();
        if (checkLegality(input) == true) {
            addToBoard(input);
            score.addTurnScore();                   // might be better in game, thought it could go here though because
            hand.addTiles();                        // score and hand are affected for the player
        }
        else {
            playWord();
        }
    }

     */
}

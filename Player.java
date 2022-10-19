/*
Class Player is in charge of all details pertaining to a player, including their hand, score, etc.
 */

public class Player {
    public Hand hand;
    public Score score;
    public String name;

    public int playerID; // might be useful in Game


    /* Creates a player description in the format to be printed, with elements name, score, and hand.
     * @return s is the string created of the player description.
     */
    public String playerDescription() {
        String s = new String("Player: " + this.name + "\nScore: " + this.score.getTotalScore()
                    + "\n Tiles: " + this.hand.toString() + "\n");
        return s;
    }


    /* Sets the name of the Player
     * @param name is the name of the player.
     * */
    public void setName(String name) {
        this.name = name;
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

package Model;

import View.ScrabbleFrame;
import View.ScrabbleView;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class of the game. This class is the model responsible to use the
 * other
 * classes to play the game.
 *
 * @author Kareem EL Assad 101107739 & Laurence Lamarche-Cliche 101173070
 * @version 3.0
 */

public class ScrabbleGame {
    public static final int SIZE = 15;
    public ArrayList<HumanPlayer> players;
    private int currentPlayerIndex;
    private List<ScrabbleView> views;
    private String[][] board;
    private Status status;

    public enum Status {
        PLACING_TILES, DONE, PASS, EXCHANGE
    };

    public ScrabbleGame() {
        Bag gameBag = new Bag();
        board = new String[SIZE][SIZE];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = " "; // fix that
            }
        }
        this.players = new ArrayList<HumanPlayer>();
        currentPlayerIndex = 0;
        views = new ArrayList<>();

    }

    public void addPlayers(int selectionCode) {
        int numPlayers;
        if (selectionCode == 3) {
            numPlayers = 1;
        } else if (selectionCode == 2) {
            numPlayers = 2;
        } else if (selectionCode == 1) {
            numPlayers = 3;
        } else {
            numPlayers = 4;
        }

        for (int i = 0; i < numPlayers; i++) {
            this.players.add(new HumanPlayer(i));
        } // first player will always have index 0, the other ones, 1, 2 and 3 (if we have
          // that many players)
    }

    public void addBoardView(ScrabbleView v) {
        views.add(v);
    }

    public void changeTurn(int currentPlayerIndex) {
        if (currentPlayerIndex == (players.size() - 1)) {
            this.currentPlayerIndex = 0; // start back at the start
        } else {
            this.currentPlayerIndex++;
        }
        status = Status.PLACING_TILES; // the only possibility for now
        int missingLetters = 7 - getCurrentPlayer().getHandLetters().size();
        getCurrentPlayer().addToHand(missingLetters);
    }

    public int getCurrentPlayerIndex() {
        return this.currentPlayerIndex;
    }

    public HumanPlayer getCurrentPlayer() {
        return this.players.get(currentPlayerIndex);
    }

    public String[][] getBoard() {
        return board;
    }

    public void updateStatus(Status status) {

        if ((status == Status.DONE) || (status == Status.PASS)) {
            changeTurn(currentPlayerIndex);
            // getCurrentPlayer().
        }
        if (status == Status.EXCHANGE) {
            getCurrentPlayer().exchangeTiles();
            changeTurn(currentPlayerIndex);
        }

        for (ScrabbleView v : views) {
            v.updateView(new ScrabbleEvent(this, "NONE", -1, -1, currentPlayerIndex));
            // we don't want to place any letter now
        }
    }

    public void placeLetter(String letterToPlace, int row, int col) {
        if (board[row][col] != " ")
            return;
        board[row][col] = letterToPlace;
        getCurrentPlayer().removeFromHand(letterToPlace);

        for (ScrabbleView v : views) {
            v.updateView(new ScrabbleEvent(this, letterToPlace, row, col, currentPlayerIndex));
        }

    }
}
package Model;

import View.BoardFrame;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Creates a scrabble board
 *
 * @author Keefer Belanger 101152085
 * @version 0.0
 */
public class Board {

    BoardFrame frame;

    public static final char TWO_LETTER_BONUS = 49;
    public static final char THREE_LETTER_BONUS = 50;
    public static final char TWO_WORD_BONUS = 51;
    public static final char THREE_WORD_BONUS = 52;
    public static final char CENTER_SQUARE = 53;

    private final int RIGHT = 0;
    private final int DOWN = 1;
    public final int BOARD_SIZE = 15;
    private int direction;
    private Letter[][] scrabble_board;
    private Letter[][] temp_board;
    private ArrayList<Letter> temp_rack;
    private static HashMap<String, String> boardScores;


    // TODO add a method to take the board GUI contents and put in inside the Letter[][] 2D array

    //only used for testing
    public Board(){
        this.direction = direction;
        this.scrabble_board = new Letter[BOARD_SIZE][BOARD_SIZE];
        this.temp_board = new Letter[BOARD_SIZE][BOARD_SIZE];
        this.temp_rack = new ArrayList<Letter>();
    }

    public Board(Game game) {
        this.direction = direction;
        this.scrabble_board = new Letter[BOARD_SIZE][BOARD_SIZE];
        this.temp_board = new Letter[BOARD_SIZE][BOARD_SIZE];
        this.temp_rack = new ArrayList<Letter>();
        this.frame = new BoardFrame(game);
    }

//    public void create_board() {
//        int i;
//        int j;
//
//        System.out.print(
//                "\n     A     B     C     D     E     F     G     H     I     J     K     L     M     N     O   \n");
//        System.out.print(
//                "   _________________________________________________________________________________________ \n");
//
//        for (i = 0; i < 15; i++) {
//            System.out.print(
//                    "  |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |\n");
//            if (i < 9)
//                System.out.print(i + 1 + " ");
//            else
//                System.out.print(i + 1);
//
//            for (j = 0; j < 15; j++) {
//                System.out.print("|  ");
//                System.out.print(scrabble_board[i][j]);
//                System.out.print("  ");
//            }
//
//            System.out.print("|\n");
//            System.out.print(
//                    "  |_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//            System.out.print("\n");
//        }
//    }

    /**
     * Place a tile on the board
     *
     * @param letter The letter that's going to be placed
     * @param row  The row cord
     * @param col  The column cord
     */
    public void place_letter(Letter letter, int row, int col) {
//        if (row < 0 || row > 14 || col < 0 || col > 14) {
//            return;
//        } don't think this is needed anymore

        this.scrabble_board[row][col] = letter;
    }

    /**
     * Place a word on the board
     * @param word The word that is doing to be placed
     * @param row  The row cord
     * @param col  The column cord
     * @param dir the direction of the word
     */
    public void place_word(Word word, int row, int col, int dir) {
        if (row < 0 || row > 14 || col < 0 || col > 14) {
            return;
        }

        for (int k = 0; k < word.getLetters().size(); k++) {
            if (dir == RIGHT) {
                this.scrabble_board[row - 1][col - 1] = word.getLetters().get(k);
                col++;

                // System.out.println(scrabble_board[row][col + 1]);
            } else if (dir == DOWN) {
                this.scrabble_board[row - 1][col - 1] = word.getLetters().get(k);
                row++;
            }

        }
    }

    public Letter[][] get_board() {
        return this.scrabble_board;
    }

//    public void print_board(char[][] b) {
//
//        int i;
//        int j;
//
//        System.out.print(
//                "\n     A     B     C     D     E     F     G     H     I     J     K     L     M     N     O   \n");
//        System.out.print(
//                "   _________________________________________________________________________________________ \n");
//
//        for (i = 0; i < 15; i++) {
//            System.out.print(
//                    "  |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |\n");
//            if (i < 9)
//                System.out.print(i + 1 + " ");
//            else
//                System.out.print(i + 1);
//            for (j = 0; j < 15; j++) {
//                if (b[i][j] == ' ') {
//                    if (i < 9) {
//                        System.out.print(b[i][j]);
//
//                    } else {
//                        System.out.print(b[i][j]);
//
//                    }
//                }
//                System.out.print("|  ");
//                System.out.print(scrabble_board[i][j]);
//                System.out.print("  ");
//            }
//
//            System.out.print("|\n");
//            System.out.print(
//                    "  |_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
//            System.out.print("\n");
//
//        }
//    }

    public void store_board() {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                temp_board[x][y] = scrabble_board[x][y];
            }
        }
    }

//    public static void main(String[] args) {
//        Board b = new Board();
//        // b.create_board();
//        String c = "Word";
//        String d = "Day";
//
//        b.place_word(c, 0, 0, 0);
//        b.place_word(d, 0, 3, 1);
//
//        b.print_board(b.scrabble_board);
//    }
}
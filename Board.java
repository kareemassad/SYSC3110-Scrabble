import java.util.ArrayList;
import java.util.HashMap;

/**
 * Creates a scrabble board
 *
 * @author Keefer Belanger 101152085
 * @version 0.0
 */
public class Board {

    private final int RIGHT = 0;
    private final int DOWN = 1;
    private int direction;
    private char[][] scrabble_board;
    private char[][] temp_board;
    private ArrayList<Character> temp_rack;
    private static HashMap<String, String> boardScores;

    public Board() {
        this.direction = direction;
        this.scrabble_board = new char[15][15];
        this.temp_board = new char[16][16];
        this.temp_rack = new ArrayList<Character>();
        this.create_board();
    }

    public char[][] get_scrabble_board() {
        return scrabble_board;
    }

    public void create_board() {
        int i;
        int j;

        System.out.print(
                "\n     A     B     C     D     E     F     G     H     I     J     K     L     M     N     O   \n");
        System.out.print(
                "   _________________________________________________________________________________________ \n");
        System.out.print(
                "  |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |\n");

        for (i = 14; i >= 0; i--) {
            if (i < 10)
                System.out.print(i + " ");
            else
                System.out.print(i);

            for (j = 0; j < 15; j++) {
                System.out.print("|  ");
                System.out.print(scrabble_board[i][j]);
                System.out.print("  ");
            }

            System.out.print("|\n");
            System.out.print(
                    "  |_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
            if (i != 0)
                System.out.print(
                        "\n  |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |\n");

            if (i == 0) {
                System.out.print("\n   ");
            }
        }
    }

    /**
     * Place a tile on the board
     * 
     * @param word The tile that's going to be placed
     * @param row  The row cord
     * @param col  The column cord
     */
    public void place_word(char word, int row, int col, int dir) {
        if (row < 0 || row > 14 || col < 0 || col > 14) {
            return;
        }

        if (temp_board[row][col] == ' ' || temp_board[row][col] == '*') {
            if (temp_rack.get(word) != ' ') {
                temp_board[row][col] = temp_rack.get(word);
                temp_rack.remove(word);
                temp_rack.add('!');
            } else {
                return;
            }
        } else {
            if (dir == RIGHT) {
                place_word(word, row, col + 1, dir);
                return;
            } else if (dir == DOWN) {
                place_word(word, row - 1, col, dir);
                return;
            }
        }

    }

    public static void main(String[] args) {
        Board b = new Board();
    }
}

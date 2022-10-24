import java.util.HashMap;

/**
 * Creates a scrabble board
 *
 * @author Keefer Belanger 101152085
 * @version 0.0
 */
public class Board {

    private char[][] scrabble_board;
    private static HashMap<String, String> board_scores;

    public Board() {
        this.scrabble_board = new char[15][15];
        this.create_board();
    }

    public void create_board()
    {
        int i;
        int j;

        System.out.print("\n     A     B     C     D     E     F     G     H     I     J     K     L     M     N     O   \n");
        System.out.print("   _________________________________________________________________________________________ \n");
        System.out.print("  |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |\n");

        for(i = 15; i >= 0; i--)
        {
            if(i < 10)
                System.out.print(i + " ");
            else
                System.out.print(i);

            for(j = 0; j < 15; j++)
            {
                System.out.print("|  ");
                System.out.print(scrabble_board[i][j]);
                System.out.print("  ");
            }

            System.out.print("|\n");
            System.out.print("  |_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
            if(i != 0)
                System.out.print("\n  |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |\n");

            if(i == 14)
            {
                System.out.print("\n   ");
            }
        }
    }

    /*
    private void create_board() {
        this.scrabble_board = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                this.scrabble_board[i][j] = ' ';
            }
        }
    }

     */

    public static void main(String[] args){
        Board board = new Board();

        board.create_board();

    }
}

import javax.swing.*;
import java.awt.*;

public class BoardFrame extends JFrame {

    Board board;
    Letter character;
    JPanel score_panel = new JPanel();
    JLabel score_label = new JLabel();

    JPanel grid_panel = new JPanel();
    JLabel[][] grid = new JLabel[board.BOARD_SIZE][board.BOARD_SIZE];
    JPanel[][] squares = new JPanel[board.BOARD_SIZE][board.BOARD_SIZE];

    public BoardFrame(Board board){
        setLayout(new BorderLayout());
        this.board = board;

        initGUI();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public void initGUI(){
        initGrid();
        add(grid_panel);
        add(score_panel, BorderLayout.SOUTH);
    }

    public void initGrid(){
        grid_panel.setLayout(new GridLayout(board.BOARD_SIZE, board.BOARD_SIZE));
        for(int row = 0; row < board.BOARD_SIZE; row++){
            for(int col = 0; col < board.BOARD_SIZE; col++){
                JPanel tile = new JPanel();
                JLabel tile_content = new JLabel("TILE");

                tile.setSize(50,50);
                tile.setBorder(BorderFactory.createEtchedBorder());
                tile.add(tile_content);

                squares[row][col] = tile;
                grid[row][col] = tile_content;
                grid_panel.add(tile);
            }
        }
    }

    public static void main(String[] args){
        Board b = new Board();
        BoardFrame bf = new BoardFrame(b);
        
    }
}

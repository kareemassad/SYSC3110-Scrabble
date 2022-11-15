import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The controller for the game
 *
 * @author Laurence Lamarche-Cliche 101173070
 * @version 0.0
 */

public class GameController implements MouseListener {
    private Game game;

    private String letter;
    private int x;
    private int y;

    public GameController(Game game){
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount()%2 == 1) {
            String input = e.toString();
            System.out.println("You chose to place letter " + input);
        }

        if(e.getClickCount()%2 == 0){ // I cannot actually test this, but please let me know if it works
            String[] input = e.getSource().toString().split(" ");
            this.x = Integer.parseInt(input[0]);
            this.y = Integer.parseInt(input[1]);
            System.out.println("at the following board location: " + x + ", "+ y);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

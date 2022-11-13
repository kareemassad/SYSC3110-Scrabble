import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Keefer Belanger 101152085
 */
public class Controller implements ActionListener {

    private Game game;
    private BoardFrame board;

    public Controller(Game g, BoardFrame bf){
        this.game = g;
        this.board = bf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

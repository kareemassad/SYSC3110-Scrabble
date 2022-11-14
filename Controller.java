import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Keefer Belanger 101152085
 */
public class Controller implements ActionListener {

    private Game game;
    private BoardFrame view;

    public Controller(Game g, BoardFrame v){
        this.game = g;
        this.view = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.play_button)){
            game.bag = new Bag();
            game.bag.getGameLetters();

            // create each player's hand
            System.out.println("\n >>> Creating each player's hand");
            for (Player player : game.players) {
                player.setHand(7);
                view.list_model.addElement(game.hand.getHand().toString());
            }
            // print player info
            for (Player player : game.players) {
                System.out.println(player.playerDescription(player));
            }
        }
        if(e.getSource() == view.num_combo_box){
            System.out.println("Test");
            int player_numbers = view.num_combo_box.getSelectedIndex() + 2;
            for (int i = 0; i < player_numbers; i++) {
                game.players.add(new Player(i));
            }
            for (Player player : game.players) {
                System.out.println(player.playerDescription(player));
            }
            view.num_combo_box.setEnabled(false);
        }
    }
}

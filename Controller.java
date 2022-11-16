import javax.swing.*;
import java.awt.*;
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
        if(e.getSource() == view.play_button){
            System.out.print("play");
        }

        if(e.getSource() == view.submit_button){
            System.out.println("submit");
        }

//        if (e.getSource() == view.num_combo_box) {
//            // get number of players from combo box
//            int num_players = Integer.parseInt((String) view.num_combo_box.getSelectedItem());
//            // create players
//            System.out.println("\n >>> Adding " + num_players + " players");
//            for (int i = 0; i < num_players; i++) {
//                game.players.add(new Player(i));
//            }
//            // print player info
//            for (Player player : game.players) {
//                System.out.println(player.playerDescription(player));
//            }
//
//            game.bag = new Bag();
//            game.bag.getGameLetters();
//
//            // create each player's hand
//            System.out.println("\n >>> Creating each player's hand");
//            for (Player player : game.players) {
//                player.setHand(7);
//                view.list_model.addElement(player.getHand());
//                view.letter_list1 = new JList(view.list_model);
//            }
//            // print player info
//            for (Player player : game.players) {
//                System.out.println(player.playerDescription(player));
//            }
//
//            view.num_combo_box.setVisible(false);
//        }
    }
}

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
            view.popup_menu.show(view,500,500);
            view.text_area.append("Select the number of players");
            view.play_button.setVisible(false);
        }

        if(e.getSource() == view.player_1_item){
            int num_players = 1;
            view.player_rack1.setVisible(true);
            System.out.println("\n >>> Adding " + num_players + " player\n");
            for(int i = 0; i < num_players; i++){
                game.players.add(new Player(i));
            }
        }
        else if (e.getSource() == view.player_2_item) {
            int num_players = 2;
            System.out.println("\n >>> Adding " + num_players + " players");
            for(int i = 0; i < num_players; i++){
                game.players.add(new Player(i));
            }
        }
        else if (e.getSource() == view.player_3_item) {
            int num_players = 3;
            System.out.println("\n >>> Adding " + num_players + " players");
            for(int i = 0; i < num_players; i++){
                game.players.add(new Player(i));
            }
        }
        else if (e.getSource() == view.player_4_item) {
            int num_players = 4;
            System.out.println("\n >>> Adding " + num_players + " players");
            for(int i = 0; i < num_players; i++){
                game.players.add(new Player(i));
            }
        }

//        if(!game.players.isEmpty()){
//            System.out.println("\n >>> Creating each player's hand");
//            for(Player player : game.players){
//                player.setHand(7);
//            }
//        }

        if(e.getSource() == view.submit_button){
            System.out.println("submit");
        }
    }
}

package Controller;

import Model.*;
import View.BoardFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controls the GUI through use of models
 * @author Keefer Belanger 101152085
 */
public class Controller implements ActionListener{

    private Game game;
    private BoardFrame view;

    public Controller(Game g, BoardFrame v){
        this.game = g;
        this.view = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.play_button){
            view.popup_menu.show(view, 125,100);
            view.text_area.append("Select the number of players\n");
            view.play_button.setVisible(false);

            game.bag = new Model.Bag();
            game.bag.getGameLetters();
        }

        //Create 1 Player
        if(e.getSource() == view.player_1_item){
            int num_players = 1;

            view.player_rack1.setVisible(true);
            view.score_label1.setVisible(true);

            System.out.println(">>> Adding " + num_players + " player");
            for(int i = 0; i < num_players; i++){
                game.players.add(new Player(i));
            }
            System.out.println(">>> Creating each player's hand");
            for (Player player : game.players) {
                player.setHand(7);
                for(int j = 0; j < player.getHand().getHand().size(); j++){
                    view.list_model1.addElement(player.getHand().getHand().get(j));
                }
            }
        }

        //Create 2 Players
        else if (e.getSource() == view.player_2_item) {
            int num_players = 2;

            view.player_rack1.setVisible(true);
            view.player_rack2.setVisible(true);

            view.score_label1.setVisible(true);
            view.score_label2.setVisible(true);

            System.out.println(">>> Adding " + num_players + " players");
            for(int i = 0; i < num_players; i++){
                game.players.add(new Player(i));
            }
            System.out.println(">>> Creating each player's hand");
            for (Player player : game.players) {
                player.setHand(7);
                for(int j = 0; j < player.getHand().getHand().size(); j++){
                    view.list_model2.addElement(player.getHand().getHand().get(j));
                }
            }
        }

        //Create 3 Players
        else if (e.getSource() == view.player_3_item) {
            int num_players = 3;

            view.player_rack1.setVisible(true);
            view.player_rack2.setVisible(true);
            view.player_rack3.setVisible(true);

            view.score_label1.setVisible(true);
            view.score_label2.setVisible(true);
            view.score_label3.setVisible(true);

            System.out.println(">>> Adding " + num_players + " players");
            for(int i = 0; i < num_players; i++){
                game.players.add(new Player(i));
            }
            System.out.println(">>> Creating each player's hand");
            for (Player player : game.players) {
                player.setHand(7);
            }
        }

        //Create 4 Players
        else if (e.getSource() == view.player_4_item) {
            int num_players = 4;

            view.player_rack1.setVisible(true);
            view.player_rack2.setVisible(true);
            view.player_rack3.setVisible(true);
            view.player_rack4.setVisible(true);

            view.score_label1.setVisible(true);
            view.score_label2.setVisible(true);
            view.score_label3.setVisible(true);
            view.score_label4.setVisible(true);

            System.out.println(">>> Adding " + num_players + " players");
            for(int i = 0; i < num_players; i++){
                game.players.add(new Player(i));
            }
            System.out.println(">>> Creating each player's hand");
            for (Player player : game.players) {
                player.setHand(7);
            }
        }

        if(e.getSource() == view.quit){
            System.exit(0);
        }

        if(e.getSource() == view.submit_button){
            for(Player player : game.players){
                System.out.println(player.playerDescription(player));
            }
        }
    }
}

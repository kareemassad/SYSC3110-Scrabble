import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.*;
import java.awt.*;
import javax.swing.TransferHandler;

/**
 * Creates the board GUI
 * @author Keefer Belanger 101152085
 */
public class BoardFrame extends JFrame{

    private Controller controller;
    private Game model;

    //South panel initialization
    JPanel south_panel = new JPanel();
    JPanel submit_panel = new JPanel();
    JButton submit_button = new JButton("Submit");
    JPanel play_panel = new JPanel();
    JButton play_button = new JButton("Play");

    //Player count initialization
    JComboBox num_combo_box;
    JLabel num_players_label = new JLabel("Choose Number of Players");
    JPanel combo_box_panel = new JPanel();
    String[] num_of_players = new String[3];

    //Scoreboard initialization
    JPanel score_panel = new JPanel();
    JLabel score_label1 = new JLabel("Player 1 Score:");
    JLabel score_label2 = new JLabel("Player 2 Score:");
    JLabel score_label3 = new JLabel("Player 3 Score:");
    JLabel score_label4 = new JLabel("Player 4 Score:");

    //Menu initialization
    JMenuBar menu_bar = new JMenuBar();
    JMenu options = new JMenu("Options");
    JMenu quit = new JMenu("Quit");
    JMenu help = new JMenu("Help");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem load = new JMenuItem("Load");
    JMenuItem redo = new JMenuItem("Redo");
    JMenuItem undo = new JMenuItem("Undo");

    //Text area initialization
    JTextArea text_area = new JTextArea(10,20);
    JScrollPane scroll_pane = new JScrollPane(text_area);

    //Player rack initialization
    JPanel rack_panel = new JPanel();
    JPanel player_rack1 = new JPanel();
    JPanel player_rack2 = new JPanel();
    JPanel player_rack3 = new JPanel();
    JPanel player_rack4 = new JPanel();

    JLabel player_num1 = new JLabel("Player 1 Rack");
    JLabel player_num2 = new JLabel("Player 2 Rack");
    JLabel player_num3 = new JLabel("Player 3 Rack");
    JLabel player_num4 = new JLabel("Player 4 Rack");

    DefaultListModel list_model = new DefaultListModel();
    JList letter_list1 = new JList(list_model);
    JList letter_list2 = new JList(list_model);
    JList letter_list3 = new JList(list_model);
    JList letter_list4 = new JList(list_model);

    //Board initialization
    JPanel grid_panel = new JPanel();
    JLabel[][] grid = new JLabel[15][15];
    JPanel[][] squares = new JPanel[15][15];

    public BoardFrame(){
        super("Scrabble");

        text_area.append("Welcome to Scrabble\n");
        text_area.append("Please choose the number of players\n");
        text_area.append("Then press the play button\n");

        this.setLayout(new BorderLayout());
        this.setSize(1920,1080);

        //South panel config
        south_panel.setLayout(new GridLayout(1,3));
        play_button.addActionListener(controller);
        play_panel.add(play_button);
        submit_panel.add(submit_button);
        south_panel.add(submit_panel);
        south_panel.add(play_panel);
        south_panel.setPreferredSize(new Dimension(0,100));

        //Player count config
        combo_box_panel.setLayout(new GridLayout(2,1));
        num_of_players[0] = "2";
        num_of_players[1] = "3";
        num_of_players[2] = "4";
        num_combo_box = new JComboBox(num_of_players);
        num_combo_box.addActionListener(controller);
        num_combo_box.setPreferredSize(new Dimension(50,50));
        combo_box_panel.add(num_players_label);
        combo_box_panel.add(num_combo_box);
        south_panel.add(combo_box_panel);

        //Scoreboard config
        score_panel.setLayout(new GridLayout(1,4));
        score_panel.add(score_label1);
        score_panel.add(score_label2);
        score_panel.add(score_label3);
        score_panel.add(score_label4);
        score_panel.setPreferredSize(new Dimension(0,35));

        //Menu config
        this.setJMenuBar(menu_bar);
        menu_bar.add(options);
        menu_bar.add(help);
        menu_bar.add(quit);
        options.add(save);
        options.add(load);
        options.add(undo);
        options.add(redo);

        //Text area config
        text_area.setEditable(false);
        scroll_pane.setPreferredSize(new Dimension(300,0));
        TextAreaOutputStream out = new TextAreaOutputStream(text_area);
        System.setOut(new PrintStream(out));

        //Rack config
        rack_panel.setLayout(new GridLayout(4,1));
        rack_panel.setPreferredSize(new Dimension(300,0));
        rack_panel.setBorder(BorderFactory.createEtchedBorder());

        player_rack1.setLayout(new GridLayout(2,1));
        player_rack2.setLayout(new GridLayout(2,1));
        player_rack3.setLayout(new GridLayout(2,1));
        player_rack4.setLayout(new GridLayout(2,1));

        player_num1.setHorizontalAlignment(JLabel.CENTER);
        player_num2.setHorizontalAlignment(JLabel.CENTER);
        player_num3.setHorizontalAlignment(JLabel.CENTER);
        player_num4.setHorizontalAlignment(JLabel.CENTER);

        player_rack1.add(player_num1);
        player_rack2.add(player_num2);
        player_rack3.add(player_num3);
        player_rack4.add(player_num4);

        //Set drag and drop
        letter_list1.setDragEnabled(true);
        letter_list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        letter_list1.setTransferHandler(new export_handler());

//        list_model.addElement(bag.getGameLetters());
        player_rack1.add(letter_list1);
        player_rack2.add(letter_list2);
        player_rack3.add(letter_list3);
        player_rack4.add(letter_list4);

        rack_panel.add(player_rack1);
        rack_panel.add(player_rack2);
        rack_panel.add(player_rack3);
        rack_panel.add(player_rack4);

        //Scrabble board config
        grid_panel.setLayout(new GridLayout(15, 15));
        for(int row = 0; row < 15; row++){
            for(int col = 0; col < 15; col++){
                Font f = new Font(Font.DIALOG, Font.BOLD, 30);
                JPanel tile = new JPanel();
                JLabel tile_content = new JLabel();
                tile_content.setFont(f);
                tile_content.setHorizontalAlignment(JLabel.CENTER);
                tile_content.setTransferHandler(new import_handler());
                tile.setBorder(BorderFactory.createEtchedBorder());

                tile_content.setPreferredSize(new Dimension(50,43));
                tile.add(tile_content);

                squares[row][col] = tile;
                grid[row][col] = tile_content;
                grid_panel.add(tile);
            }
        }

        this.add(south_panel, BorderLayout.SOUTH);
        this.add(rack_panel, BorderLayout.WEST);
        this.add(scroll_pane, BorderLayout.EAST);
        this.add(score_panel, BorderLayout.NORTH);
        this.add(grid_panel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private class import_handler extends TransferHandler {
        public final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;

        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(SUPPORTED_DATE_FLAVOR);
        }

        public boolean importData(TransferSupport support) {
            boolean accept = false;
            if (canImport(support)) {
                try {
                    Transferable t = support.getTransferable();
                    Object value = t.getTransferData(SUPPORTED_DATE_FLAVOR);
                    if (value instanceof String) {
                        Component component = support.getComponent();
                        if (component instanceof JLabel) {
                            ((JLabel) component).setText(value.toString());
                            accept = true;
                        }
                    }
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
            return accept;
        }

    }

    private class export_handler extends TransferHandler {
        private int[] indices = null;
        private int addIndex = -1; //Location where items were added
        private int addCount = 0;  //Number of items added.

        protected Transferable createTransferable(JComponent c) {
            JList list = (JList) c;
            indices = list.getSelectedIndices();
            Object[] values = list.getSelectedValues();

            StringBuffer buff = new StringBuffer();

            for (int i = 0; i < values.length; i++) {
                Object val = values[i];
                buff.append(val == null ? "" : val.toString());
                if (i != values.length - 1) {
                    buff.append("\n");
                }
            }
            return new StringSelection(buff.toString());
        }

        public int getSourceActions(JComponent c) {
            return TransferHandler.COPY_OR_MOVE;
        }

        protected void exportDone(JComponent c, Transferable data, int action) {
            JList source = (JList)c;
            DefaultListModel listModel  = (DefaultListModel)source.getModel();

            if (action == TransferHandler.MOVE) {
                for (int i = indices.length - 1; i >= 0; i--) {
                    listModel.remove(indices[i]);
                }
            }

            indices = null;
            addCount = 0;
            addIndex = -1;
        }
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() ->{
            new BoardFrame();
        });
    }
}

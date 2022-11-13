import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.PrintStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.TransferHandler;
import javax.swing.plaf.basic.BasicListUI;

/**
 * Creates the board GUI
 * @author Keefer Belanger 101152085
 */
public class BoardFrame extends JFrame {

    Board board;
    Letter character;
    Bag bag;
    Hand hand;

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
    JList letter_list = new JList(list_model);

    //Board initialization
    JPanel grid_panel = new JPanel();
    JLabel[][] grid = new JLabel[15][15];
    JTextArea[][] squares = new JTextArea[15][15];

    public BoardFrame(){
        super("Scrabble");

        this.setLayout(new BorderLayout());
        this.setSize(1920,1080);

        //South panel config
        south_panel.setLayout(new GridLayout(1,3));
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

        //Set drag and drop
        letter_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        letter_list.setTransferHandler(new ListHandler());

        letter_list.setDragEnabled(true);

        player_rack1.add(player_num1);
        player_rack2.add(player_num2);
        player_rack3.add(player_num3);
        player_rack4.add(player_num4);

        list_model.addElement("A");
        list_model.addElement("B");
        list_model.addElement("C");
        player_rack1.add(letter_list);

        rack_panel.add(player_rack1);
        rack_panel.add(player_rack2);
        rack_panel.add(player_rack3);
        rack_panel.add(player_rack4);

//        player_grid_panel.setLayout(new GridLayout(1,7));
//        for(Letter L : hand.getHand()){
//
//            sb.append(L == null ? "" : hand.toString());
//
//            JPanel player_tile = new JPanel();
//            JLabel bag_letter = new JLabel("TEST");
//
//            player_tile.setBorder(BorderFactory.createEtchedBorder());
//            bag_letter.setHorizontalAlignment(JLabel.CENTER);
//            bag_letter.setVerticalAlignment(JLabel.CENTER);
//            player_tile.setPreferredSize(new Dimension(50,50));
//            player_tile.add(bag_letter);
//
//            rack_grid[i] = player_tile;
//            player_grid_panel.add(player_tile);
//            player_rack1.add(player_grid_panel);
//        }
//
//        player_num1.setText(sb.toString());

        //Scrabble board config
        grid_panel.setLayout(new GridLayout(15, 15));

        for(int row = 0; row < 15; row++){
            for(int col = 0; col < 15; col++){
                JTextArea tile = new JTextArea();
                tile.setEditable(true);
                tile.setDragEnabled(true);

                tile.setBorder(BorderFactory.createEtchedBorder());

                tile.setPreferredSize(new Dimension(50,50));

                tile.setDropMode(DropMode.INSERT);
                tile.setTransferHandler(new ListHandler());

                squares[row][col] = tile;
                //grid[row][col] = tile_content;
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

    private class ListHandler extends TransferHandler{
        private int[] indices = null;
        private int addIndex = -1; //Location where items were added
        private int addCount = 0;  //Number of items added.
        /**
         * We only support importing strings.
         */
        public boolean canImport(TransferHandler.TransferSupport info) {
            // Check for String flavor
            if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return false;
            }
            return true;
        }

        /**
         * Bundle up the selected items in a single list for export.
         * Each line is separated by a newline.
         */
        protected Transferable createTransferable(JComponent c) {
            JList list = (JList)c;
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

        /**
         * We support both copy and move actions.
         */
        public int getSourceActions(JComponent c) {
            return TransferHandler.COPY_OR_MOVE;
        }

        /**
         * Perform the actual import.  This demo only supports drag and drop.
         */
        public boolean importData(TransferHandler.TransferSupport info) {
            if (!info.isDrop()) {
                return false;
            }

            JList list = (JList)info.getComponent();
            DefaultListModel listModel = (DefaultListModel)list.getModel();
            JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
            int index = dl.getIndex();
            boolean insert = dl.isInsert();

            // Get the string that is being dropped.
            Transferable t = info.getTransferable();
            String data;
            try {
                data = (String)t.getTransferData(DataFlavor.stringFlavor);
            }
            catch (Exception e) { return false; }

            // Wherever there is a newline in the incoming data,
            // break it into a separate item in the list.
            String[] values = data.split("\n");

            addIndex = index;
            addCount = values.length;

            // Perform the actual import.
            for (int i = 0; i < values.length; i++) {
                if (insert) {
                    listModel.add(index++, values[i]);
                } else {
                    // If the items go beyond the end of the current
                    // list, add them in.
                    if (index < listModel.getSize()) {
                        listModel.set(index++, values[i]);
                    } else {
                        listModel.add(index++, values[i]);
                    }
                }
            }
            return true;
        }

        /**
         * Remove the items moved from the list.
         */
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

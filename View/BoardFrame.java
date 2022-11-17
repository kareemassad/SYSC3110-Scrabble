package View;

import Model.Game;
import Model.TextAreaOutputStream;
import Controller.Controller;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.PrintStream;
import javax.swing.*;
import java.awt.*;
import javax.swing.TransferHandler;

/**
 * Creates the board GUI
 * @author Keefer Belanger 101152085
 */
public class BoardFrame extends JFrame{

    //private Game model;
    private Controller controller;

    //South panel initialization
    JPanel south_panel = new JPanel();
    JPanel submit_panel = new JPanel();
    public JButton submit_button = new JButton("Submit");
    JPanel play_panel = new JPanel();
    public JButton play_button = new JButton("Play");

    //Player count initialization
    public JMenuItem player_1_item = new JMenuItem("Player 1");
    public JMenuItem player_2_item = new JMenuItem("Player 2");
    public JMenuItem player_3_item = new JMenuItem("Player 3");
    public JMenuItem player_4_item = new JMenuItem("Player 4");

    public JPopupMenu popup_menu = new JPopupMenu("Player Selection");

    //Scoreboard initialization
    JPanel score_panel = new JPanel();
    public JLabel score_label1 = new JLabel("Player 1 Score:");
    public JLabel score_label2 = new JLabel("Player 2 Score:");
    public JLabel score_label3 = new JLabel("Player 3 Score:");
    public JLabel score_label4 = new JLabel("Player 4 Score:");

    //Menu initialization
    JMenuBar menu_bar = new JMenuBar();
    JMenu options = new JMenu("Options");
    JMenu help = new JMenu("Help");

    public JMenuItem quit = new JMenuItem("Quit");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem load = new JMenuItem("Load");
    JMenuItem redo = new JMenuItem("Redo");
    JMenuItem undo = new JMenuItem("Undo");

    //Text area initialization
    public JTextArea text_area = new JTextArea(10,20);
    JScrollPane scroll_pane = new JScrollPane(text_area);

    //Player rack initialization
    JPanel rack_panel = new JPanel();
    public JPanel player_rack1 = new JPanel();
    public JPanel player_rack2 = new JPanel();
    public JPanel player_rack3 = new JPanel();
    public JPanel player_rack4 = new JPanel();

    JLabel player_num1 = new JLabel("Player 1 Rack");
    JLabel player_num2 = new JLabel("Player 2 Rack");
    JLabel player_num3 = new JLabel("Player 3 Rack");
    JLabel player_num4 = new JLabel("Player 4 Rack");

    public DefaultListModel list_model1 = new DefaultListModel();
    public DefaultListModel list_model2 = new DefaultListModel();
    public DefaultListModel list_model3 = new DefaultListModel();
    public DefaultListModel list_model4 = new DefaultListModel();

    JList letter_list1 = new JList(list_model1);
    JList letter_list2 = new JList(list_model2);
    JList letter_list3 = new JList(list_model3);
    JList letter_list4 = new JList(list_model4);

    //Model.Board initialization
    JPanel grid_panel = new JPanel();
    JLabel[][] grid = new JLabel[15][15];
    JPanel[][] squares = new JPanel[15][15];

    public BoardFrame(Game game){
        super("Scrabble");
        this.controller = new Controller(game, this);

        text_area.append("Welcome to Scrabble\n");
        text_area.append("Press the play button to start the game\n");

        this.setLayout(new BorderLayout());

        //South panel config
        south_panel.setLayout(new GridLayout(1,3));
        play_button.addActionListener(controller);
        submit_button.addActionListener(controller);
        play_panel.add(play_button);
        submit_panel.add(submit_button);
        south_panel.add(submit_panel);
        south_panel.add(play_panel);
        south_panel.setPreferredSize(new Dimension(0,100));

        //Player count config
        popup_menu.setLocation(play_button.getLocation());
        popup_menu.setLayout(new GridLayout(4,1));

        player_1_item.addActionListener(controller);
        player_2_item.addActionListener(controller);
        player_3_item.addActionListener(controller);
        player_4_item.addActionListener(controller);

        popup_menu.add(player_1_item);
        popup_menu.add(player_2_item);
        popup_menu.add(player_3_item);
        popup_menu.add(player_4_item);

        //Scoreboard config
        score_panel.setLayout(new GridLayout(1,4));
        score_panel.setPreferredSize(new Dimension(0,35));
        score_panel.add(score_label1);
        score_panel.add(score_label2);
        score_panel.add(score_label3);
        score_panel.add(score_label4);

        score_label1.setVisible(false);
        score_label2.setVisible(false);
        score_label3.setVisible(false);
        score_label4.setVisible(false);

        //Menu config
        this.setJMenuBar(menu_bar);
        menu_bar.add(options);
        menu_bar.add(help);
        options.add(save);
        options.add(load);
        options.add(undo);
        options.add(redo);
        options.add(quit);

        quit.addActionListener(controller);

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

        letter_list1.setLayoutOrientation(JList.VERTICAL_WRAP);
        letter_list1.setVisibleRowCount(1);

        letter_list2.setDragEnabled(true);
        letter_list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        letter_list2.setTransferHandler(new export_handler());

        letter_list2.setLayoutOrientation(JList.VERTICAL_WRAP);
        letter_list2.setVisibleRowCount(1);

        letter_list3.setDragEnabled(true);
        letter_list3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        letter_list3.setTransferHandler(new export_handler());

        letter_list3.setLayoutOrientation(JList.VERTICAL_WRAP);
        letter_list3.setVisibleRowCount(1);

        letter_list4.setDragEnabled(true);
        letter_list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        letter_list4.setTransferHandler(new export_handler());

        letter_list4.setLayoutOrientation(JList.VERTICAL_WRAP);
        letter_list4.setVisibleRowCount(1);

        player_rack1.add(letter_list1);
        player_rack2.add(letter_list2);
        player_rack3.add(letter_list3);
        player_rack4.add(letter_list4);

        player_rack1.setVisible(false);
        player_rack2.setVisible(false);
        player_rack3.setVisible(false);
        player_rack4.setVisible(false);

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
                tile.setLayout(new GridLayout());
                tile.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                JLabel tile_content = new JLabel(" ");
                tile_content.setFont(f);
                tile_content.setHorizontalAlignment(JLabel.CENTER);
                tile_content.setTransferHandler(new import_handler());
                tile.setBorder(BorderFactory.createEtchedBorder());

                tile_content.setPreferredSize(new Dimension(50,35));
                tile.add(tile_content);

                switch(row){
                    //Coloring top row to bottom row (left to right)
                    case 0:
                        if(row == 0 && col == 0){
                            tile.setBackground(new Color(255,102,178));
                        }
                    case 1:
                        if(row == 0 && col == 7){
                            tile.setBackground(new Color(255,102,178));
                        }
                    case 2:
                        if(row == 0 && col == 14){
                            tile.setBackground(new Color(255,102,178));
                        }
                    case 3:
                        if(row == 1 && col == 1){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 4:
                        if(row == 1 && col == 5){
                            tile.setBackground(new Color(51,153,255));
                        }
                    case 5:
                        if(row == 1 && col == 9){
                            tile.setBackground(new Color(51,153,255));
                        }
                    case 6:
                        if(row == 1 && col == 13){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 7:
                        if(row == 2 && col == 2){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 8:
                        if(row == 2 && col == 6){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 9:
                        if(row == 2 && col == 8){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 10:
                        if(row == 2 && col == 12){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 11:
                        if(row == 3 && col == 3){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 12:
                        if(row == 3 && col == 7){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 13:
                        if(row == 3 && col == 7){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 14:
                        if(row == 3 && col == 11){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 15:
                        if(row == 4 && col == 4){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 16:
                        if(row == 4 && col == 10){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 17:
                        if(row == 5 && col == 1){
                            tile.setBackground(new Color(51,153,255));
                        }
                    case 18:
                        if(row == 5 && col == 5){
                            tile.setBackground(new Color(51,153,255));
                        }
                    case 19:
                        if(row == 5 && col == 9){
                            tile.setBackground(new Color(51,153,255));
                        }
                    case 20:
                        if(row == 5 && col == 13){
                            tile.setBackground(new Color(51,153,255));
                        }
                    case 21:
                        if(row == 6 && col == 2){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 22:
                        if(row == 6 && col == 6){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 23:
                        if(row == 6 && col == 8){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 24:
                        if(row == 6 && col == 12){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 25:
                        if(row == 7 && col == 0){
                            tile.setBackground(new Color(255,102,178));
                        }
                    case 26:
                        if(row == 7 && col == 3){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 27:
                        if(row == 7 && col == 7){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 28:
                        if(row == 7 && col == 11){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 29:
                        if(row == 7 && col == 14){
                            tile.setBackground(new Color(255,102,178));
                        }
                    case 30:
                        if(row == 8 && col == 2){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 31:
                        if(row == 8 && col == 6){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 32:
                        if(row == 8 && col == 8){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 33:
                        if(row == 8 && col == 12){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 34:
                        if(row == 9 && col == 1){
                            tile.setBackground(new Color(51,153,255));
                        }
                    case 35:
                        if(row == 9 && col == 5){
                            tile.setBackground(new Color(51,153,255));
                        }
                    case 36:
                        if(row == 9 && col == 9){
                            tile.setBackground(new Color(51,153,255));
                        }
                    case 37:
                        if(row == 9 && col == 13){
                            tile.setBackground(new Color(51,153,255));
                        }
                    case 38:
                        if(row == 10 && col == 4){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 39:
                        if(row == 10 && col == 10){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 40:
                        if(row == 11 && col == 3){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 41:
                        if(row == 11 && col == 7){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 42:
                        if(row == 11 && col == 11){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 43:
                        if(row == 12 && col == 2){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 44:
                        if(row == 12 && col == 6){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 45:
                        if(row == 12 && col == 8){
                            tile.setBackground(new Color(153,204,255));
                        }
                    case 46:
                        if(row == 12 && col == 12){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 47:
                        if(row == 13 && col == 1){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 48:
                        if(row == 13 && col == 5){
                            tile.setBackground(new Color(51,153,255));
                        }
                    case 49:
                        if(row == 13 && col == 9){
                            tile.setBackground(new Color(51,153,255));
                        }
                    case 50:
                        if(row == 13 && col == 13){
                            tile.setBackground(new Color(255,204,229));
                        }
                    case 51:
                        if(row == 14 && col == 0){
                            tile.setBackground(new Color(255,102,178));
                        }
                    case 52:
                        if(row == 14 && col == 7){
                            tile.setBackground(new Color(255,102,178));
                        }
                    case 53:
                        if(row == 14 && col == 14){
                            tile.setBackground(new Color(255,102,178));
                        }
                }

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
        pack();
    }

    private class import_handler extends TransferHandler {
        public final DataFlavor SUPPORTED_DATA_FLAVOR = DataFlavor.stringFlavor;

        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(SUPPORTED_DATA_FLAVOR);
        }

        public boolean importData(TransferSupport support) {
            boolean accept = false;
            if (canImport(support)) {
                try {
                    Transferable t = support.getTransferable();
                    Object value = t.getTransferData(SUPPORTED_DATA_FLAVOR);
                    if (value instanceof String) {
                        Component component = support.getComponent();
                        if (component instanceof JLabel) {
                            System.out.println(value.getClass());
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
}

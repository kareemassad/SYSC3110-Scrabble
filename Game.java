import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main class of the game. This class will be responsible to use the other
 * classes to play the game.
 *
 * @author Kareem EL Assad 101107739
 * @version 0.0
 */

public class Game {
    // The game will have a board, a bag, and a list of players
    private Board board;
    private BoardFrame boardframe;
    public Bag bag;
    public Hand hand;
    public ArrayList<Player> players;
    private int currentPlayerIndex;
    private Player currentPlayer;
    private int turnNumber;
    private int maxTurns;

    public Game() {
        this.board = new Board();
        this.boardframe = new BoardFrame();
        this.bag = new Bag();
        this.players = new ArrayList<Player>();
        this.currentPlayerIndex = 0;
        this.turnNumber = 0;
        this.maxTurns = 6;
    }

    public void init_game(Game game) {
        // This will initialize the game
        // it will create the players, the board, and the bag
        // ask player how many players are playing
//        System.out.println("\n >>> How many players are playing? (int)");
//        Scanner scanner = new Scanner(System.in);
//        int num_players = scanner.nextInt();

//        if (num_players < 2 || num_players > 4) {
//            System.out.println("\n >>> Invalid number of players. Please enter a number between 2 and 4.");
//            init_game(game);
//        }

//        // create players
////        System.out.println("\n >>> Adding " + num_players + " players");
////        for (int i = 0; i < num_players; i++) {
////            game.players.add(new Player(i));
////        }

//        // print player info
//        for (Player player : game.players) {
//            System.out.println(player.playerDescription(player));
//        }

//        // create the bag
//        game.bag = new Bag();
//        game.bag.getGameLetters();
//        game.bag.print_bag();

        // create each player's hand
//        System.out.println("\n >>> Creating each player's hand");
//        for (Player player : game.players) {
//            player.setHand(7);
//        }
//        // print player info
//        for (Player player : game.players) {
//            System.out.println(player.playerDescription(player));
//        }

        // create the board
//        game.board = new Board();
//        game.board.create_board();
    }

    // method to remove used tiles from player's hand
    private void remove_tiles(String word, Player player) {
        // split the word into an array of chars
        char[] word_array = word.toCharArray();
        // for each tile in the player's hand,
        // place the tile on row and col on the board
        for (int i = 0; i < word_array.length; i++) {
            // remove the tile from the player's hand using removeFromHand in Hand
            player.remove_from_hand(Character.toString(word_array[i]));
        }
        // draw new tiles from the bag
        player.add_to_hand(word_array.length);
    }

    private void play(Player curr_player) {
        // ask player for what they want to do
        System.out.println("\n >>> What would you like to do? (int)");
        System.out.println(" >>> 1. Place a tile");
        System.out.println(" >>> 2. Exchange tiles");
        System.out.println(" >>> 3. Pass");
        System.out.println(" >>> 4. Quit");

        Scanner scanner = new Scanner(System.in);
        int player_choice = scanner.nextInt();
        // error checking
        while (player_choice < 1 || player_choice > 4) {
            System.out.println("\n >>> Invalid input. Please enter an integer between 1 and 4.");
            player_choice = scanner.nextInt();
        }

        switch (player_choice) {
            case 1:
                // place a tile
                System.out.println("\n >>> Player " + currentPlayerIndex + " chose to place a tile");
                System.out.println(
                        "\n >>> What word would you like to place and where? (String word, int row, int col, int direction [right = 0, down = 1])");
                String word = scanner.next();
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                int dir = scanner.nextInt();
                // given "test", 0, 0, 0
                // it will place t,e,s,t on the board at 0,0, 0,1, 0,2, 0,3 horizontally
                // place word
                board.place_word(word, row, col, dir);
                // add score to player's total score
                curr_player.addScore(new Word(word));
                // remove tiles from player's hand
                remove_tiles(word, curr_player);

                break;
            case 2:
                // exchange tiles
                System.out.println("\n >>> Player " + currentPlayerIndex + " chose to exchange tiles");
                System.out.println("\n >>> What tiles would you like to exchange? (String word)");
                String tiles_to_exchange = scanner.next();
                // remove tiles from player's hand
                remove_tiles(tiles_to_exchange, curr_player);
                // add new tiles to player's hand
                currentPlayer.add_to_hand(tiles_to_exchange.length());

                break;
            case 3:
                // pass
                System.out.println("\n >>> Player " + currentPlayerIndex + " chose to pass");
                break;
            case 4:
                // quit
                System.out.println("\n >>> Player " + currentPlayerIndex + " chose to quit");
                System.out.println("\n >>> Thanks for playing!");
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
//        game.init_game(game);

        // game loop
        while (game.turnNumber < game.maxTurns) {
            System.out.println("\n >>> Turn " + game.turnNumber);
            // get current player
            game.currentPlayer = game.players.get(game.currentPlayerIndex);
            System.out.println("\n >>> Current player: " + game.currentPlayer.playerDescription(game.currentPlayer));

            // print board
//            game.board.print_board(game.board.get_board());

            // play
            game.play(game.currentPlayer);

            // after each player played their turn, increment the turn number
            game.turnNumber++;
            // after each player played their turn, increment the current player index
            game.currentPlayerIndex++;
            // if the current player index is greater than the number of players, reset it
            // to 0
            if (game.currentPlayerIndex >= game.players.size()) {
                game.currentPlayerIndex = 0;
            }
        }
    }
}
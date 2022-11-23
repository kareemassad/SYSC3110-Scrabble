# SYSC3110-Scrabble

## SYSC 3110 Project - Group 35

Note: All team members believe that all team members contributed equally as not all work is reflected in the commits

## Project Authors

* Kareem El Assad : 101107739
* Becca Young : 101183297
* Keefer Belanger : 101152085
* Laurence Lamarche-Cliche : 101173070

## Future deliverables

This deliverable is the third milestone of a series of four milestones.

## Known Issues

1. The first word placed will score its last letter letter twice. This is due to the fact that the Word class adds one too many letters in the word (it adds the last letter twice). This happens only for the first player, on the first turn
2. Our Legality class’s logic works, but it is not implemented in the game because it was not finished in time. When given a word, it can determine if it is part of the database or not. 
3. The logic for Exchanging tiles has not been implemented in time and therefore, the button has been disabled for now. The function exchangeTiles() in the Model.Player class does not currently work.
4. There is a BUG (apparently, it does not generate any error messages, or show up in the debugger) that prevents us from using the last 5 rows AND columns of the board. When we try placing a letter on it by pressing the button, nothing happens. Therefore, please play for now using only the first 10x10 squares of the board.

### Left For Remaining Milestones

* Add multiple level undo and redo
* Add saving and loading features for a board
* Adapt Model.ScrabbleGame and View.ScrabbleFrame classes to use and display premium and blank tiles (Milestone 4). The Model.Letter class and the Model.Score classes already have the correct logic implemented

## Design Decisions

* We decided to use a .txt file to store the legal words. This will allow us to easily create different scrabble legal word sets. It is currently stored in the Words folder and imported into java in the `Model.Legality2 Class`.
* We chose to refactor the whole project in a MVC logic, separating the view from the game logic and having a separate controller class. The difference with milestone is the addition of a Scrabble Event class, that gets passed on the view for updating. The interface ScrabbleView demands implementation of an update method, which is implemented in the ScrabbleView class. 
* We decided to make the runnable class the ScrabbleFrame class, just like the TicTacToe example discussed in the class. That way, it can have a model and a controller. 
* We are using a 2D array of Strings to represent the board, and this is done because we can place Letter objects using their toString() method and because we can append to these strings the premium tiles logic, which we have also implemented as a String. That way, we can save the premium for the letter and the letter when we will want to implement the save and load features and have ScrabbleGame.board[row][col] = “A” when there is no premium, and “ADL” when there is, for example, a DL (double letter) premium to store. The ScrabbleFrame class can display only the first character, and store the other ones inside a Letter object when reloading a saved board. 
* We chose to abandon the drag and drop logic that we had tried for milestone 2 and replace the board’s panels with a grid made of buttons. Then, to place a tile, a player must click on the letter from its hand, then click on the board location at which he wants to place it. The controller saves the letter to place with the first click, and places it on the second click.
* We decided the create a Player interface and have HumanPlayer and AIPlayer classes implement that interface. The AI player is automatically initialized when the game is started with the selected number of player as 1.


## User Manual

Once the user chooses to play Scrabble (by running Model.Game.java), they will be asked to choose the number of players (between 1 and 4). Choosing 1 will automatically generate a second AI player to play against.

The number of players will be created along with their ID, Scores, and Hands.
The Model.Bag of available letters will be created then the game will automatically assign 7 letters to each player.

The system will then print the empty board.

The first player will be prompted to play their turn.

During their turn, a player has 4 options.

* Place a word
* Exchange tiles (currently DISABLED)
* Pass their Turn
* Quit the Game

If a player chooses to place a word, they will have to click on the letter they want to place , then click on the location of the board they want to place it on, and repeat that for each letter of the word. Once done, they must click on the SUBMIT button so that the system can then determine if the word is legal or not and compute their score.

CURRENTLY NOT ENABLED - If a player chooses to exchange tiles, they will be prompted to click on the letters they want to exchange. The system will then replace the letters in their hand with new letters from the bag and pass their turn.

If a player chooses to pass their turn, the system will pass their turn and move on to the next player.

If a player chooses to quit the game, the system will end the game. In the future, it will also print the final scores of the players.

## UML Diagrams

![UML Diagram](/imgs/Scrabble_UML_milestone3.png)

### Sequence Diagram
![SEQUENCE Diagram](/imgs/Scrabble_SequenceDiagram_milestone3.png)




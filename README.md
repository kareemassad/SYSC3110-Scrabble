# SYSC3110-Scrabble

## SYSC 3110 Project - Group 35

Note: All team members believe that all team members contributed equally as not all work is reflected in the commits

## Project Authors

* Kareem El Assad : 101107739
* Becca Young : 101183297
* Keefer Belanger : 101152085
* Laurence Lamarche-Cliche : 101173070

## Future deliverables

This deliverable is the second milestone of a series of four milestones.

## Known Issues

1.	We are not currently validating the placement of words on the board, legality so far only checks that a word played is a real word.
2.	Occasionally, if the player tries to replace their tiles with tiles from the bag, they will have 1 less letter than they should.
3. We are currently not preventing a player to draw more letters than he can hold in his Hand.
4. The Controller class is currently not updating the view properly. When you click on something, it is not updated in the view. This will be fixed for the next milestone. 
5. There is an example GUI running in BoardFrame (when Game is running). When the BoardFrame is launched, you can place letters on it from the rack.

### Left For Remaining Milestones

•	Finish the Score implementation to ensure that new letters and words are scored and ensuring that all tests pass (Milestone 3)
• Alter implementation of when words are played ensuring Legality will pass correctly (Milestone 3)
•	Create a Scrabble playing AI (Milestone 4)
•	Adapt the Score and Board classes to use premium and wild tiles (Milestone 4)


## Design Decisions

•	We decided to use a .txt file to store the legal words. This will allow us to easily create different scrabble legal word sets. It is currently stored in the Words folder and imported into java in the Legality Class.
•	We decided to design it so all of the classes are separated with their own methods instead of having them all in one class to loosen the coupling of the classes so we could change that class without having a direct effect on the other classes. We also did this to increase the cohesion between classes so they could all have their own tasks to later be called in Game.
•	We chose to refactor the Bag class to use a HashMap instead of an ArrayList to store the letters. We wanted to do this to improve the efficiency of accessing letters from the bag.
•	We chose to implement a drag and drop logic for the GUI such that a player can place its letters on the board. This implies that we need to have a “submit” button so that the score is only calculated once the player is done with his word. This also involved using two private classes inside BoardFrame:
  •	the private class import_handler is for the grid squares, and is necessary to know if the data can be transfered onto the grid squares on to the board.
The method import_data gets the actual transferable, the item that gets dragged over.
  •	The private class export_handler holds the protected function createTransferable. As soon as a player clicks on something to drag it, this method will create a transferable. The exportDone method is to manage a player's rack. As soon as a Letter is dragged out of the rack, it will remove the letter  from the rack such that it can no longer be used. 
•	We have decided to hardcode the size of the scrabble board (15x15) since the size of a Scrabble board does not change.


## User Manual

Once the user chooses to play Scrabble (by running Game.java), they will be asked to choose the number of players (between 2 and 4)

The number of players will be created along with their ID, Scores, and Hands.
The Bag of available letters will be printed to the console then the game will automatically assign a rack of letters to each player.

The system will then print the empty board.

The first player will be prompted to play their turn.

During their turn, a player has 4 options.

* Place a word
* Exchange tiles
* Pass their Turn
* Quit the Game

If a player chooses to place a word, they will have to click on the letter they want to place and drag and drop it on the location of the board (the tile) they want to place it on, and repeat that for each letter of the word. Once done, they must click on the SUBMIT button so that the system can then determine if the word is legal or not and compute their score.

If a player chooses lear as their word, and they want to place it in the top left corner of the board, they would enter 1 for the row, 1 for the column, and 0 (right) or 1 (down) for the direction.

If a player chooses to exchange tiles, they will be prompted to click on the letters they want to exchange. The system will then replace the letters in their hand with new letters from the bag and pass their turn.

If a player chooses to pass their turn, the system will pass their turn and move on to the next player.

If a player chooses to quit the game, the system will end the game. In the future, it will also print the final scores of the players.

## UML Diagrams

![UML Diagram](/imgs/ScrabbleUML-Milestone2.png)

### Sequence Diagram
![SEQUENCE Diagram](/imgs/ScrabbleSequenceDiagram.png)



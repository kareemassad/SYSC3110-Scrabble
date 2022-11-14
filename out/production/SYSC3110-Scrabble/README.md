# SYSC3303-Scrabble

<<<<<<< HEAD
-- Authors

Keefer Belanger - 101152085
Laurence Lamarche-Cliche - 101173070
Becca Young - 101183297

-- Future deliverables

This deliverable is the first milestone of a series of four milestones. 

Left to do in the remaining milestones is to implement the board full user interface and Unit tests (Milestone 2), 
finish the Score implementation to ensure that new letters and words are scored and ensuring that all tests pass (Milestone 3), 
create a Scrabble playing AI (Milestone 4) and adapt the Score and Board classes to the new use of premium tiles 
and blank tiles (Milestone 4). 

-- Known issues 

1. We are urrently scoring and validating as if what was placed is a word (in all directions)
2. For now, we are not verifying that the tile that a user wants to place is actually in its hand (available to place)
3. To avoid creating any issues related to the previous one, we do not check if a letter was actually in the hand 
before removing it from the hand (after it has allegedly been played). Trying to remove a letter that is not in the hand 
will not cause an error, but eventually it should raise an error. 
4. We have both camel case and snake case mixed in our classes and UML diagrams, this will be fixed next Milestone.
=======
## SYSC 3110 Project - Group 35

Note: All team members believe that all team members contributed equally as not all work is reflected in the commits

## Project Authors

* Kareem El Assad : 101107739
* Becca Young : 101183297
* Keefer Belanger : 101152085
* Laurence Lamarche-Cliche : 101173070

## Future deliverables

This deliverable is the first milestone of a series of four milestones.

## Known Issues

1. We are not currently scoring and validating the placement of words on the board. We were able to implement a half-working `Score Class` but were unable to finish it in time.
2. For now, we are not verifying that the tile that a user wants to place is actually in their hand (available to place)
3. To avoid creating any issues related to the previous one, we do not check if a letter was actually in the hand before removing it from the hand (after it has allegedly been played). Trying to remove a letter that is not in the hand  will not cause an error, but eventually it should raise an error.
4. We have both camel case and snake case mixed in our classes and UML diagrams, this will be fixed next Milestone.
5. Occasionally, if the player tries to replace their tiles with tiles from the bag, they will have 1 less letter than they should.
6. We currently do not have strong error checking built in to verify that user input is valid. This will be fixed in the next milestone.

### Left For Remaining Milestones

* Implement the GUI User Interface and Unit Tests (Milestone 2)
* Finish the Score implementation to ensure that new letters and words are scored and ensuring that all tests pass (Milestone 3)
* Create a Scrabble playing AI (Milestone 4)
* Adapt the Score and Board classes to use premium and wild tiles (Milestone 4)

## Design Decisions

* We decided to use a .txt file to store the legal words. This will allow us to easily create different scrabble legal word sets. It is currently stored in the Words folder and imported into java in the `Legality Class`.
* We decided to design it so all of the classes are seperated with their own methods instead of having them all in one class to loosen the coupling of the classes so we could change that class without having a direct effect on the other classes. We also did this to increase the cohesion between classes so they could all have their own tasks to later be called in Game.
* Currently, we are using an `ArrayList` to store the letters in the `Bag Class` but we intend to change it to a `HashMap` to improve the efficiency to access letters from the bag.

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

If a player chooses to place a word, they will be prompted to enter the word they want to place, the row and column they want to place it in, and the direction they want to place it in.

The top left corner of the board can be considered as `(1,1)` and the bottom right corner of the board can be considered as `(15,15)`.

Later on, this will be replaced with `(1,A)` and `(15, O)` to match the actual Scrabble board before transitioning into a GUI.

If a player chooses `lear` as their word, and they want to place it in the top left corner of the board, they would enter `1` for the row, `1` for the column, and `0 (right) or 1 (down)` for the direction.

If a player chooses to exchange tiles, they will be prompted to enter the letters they want to exchange. The system will then replace the letters in their hand with new letters from the bag and pass their turn.

If a player chooses to pass their turn, the system will pass their turn and move on to the next player.

If a player chooses to quit the game, the system will end the game. In the future, it will also print the final scores of the players.

## UML Diagrams

![UML Diagram](/imgs/ScrabbleUML.png)
>>>>>>> c2a8525c5d3b17fd76614b466af43eb5d5e6566a

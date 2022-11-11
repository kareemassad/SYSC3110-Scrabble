# SYSC3303-Scrabble

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

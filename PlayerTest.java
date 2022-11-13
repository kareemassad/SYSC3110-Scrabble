import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testPlayerConstructor(){
        Player p1 = new Player(1);
        assertNotNull(p1);
        assertNotNull(p1.getHand());
        assertEquals(0, p1.getHand().getHand().size()); // Initializes a non-null, empty Hand
        assertEquals(0, p1.getScore()); //initializes score to 0
    }

    @Test
    public void testPlayerDescription(){
        Player p1 = new Player(1);

        String expectedDescription = new String("Player ID: " + 1 + "\n Score: " + 0
                + "\n Tiles: " + "" + "\n");

        assertEquals(expectedDescription, p1.playerDescription(p1));
    }

    @Test
    // this test fails
    public void testSetScore(){
        Player p = new Player(0);
        Word hi = new Word("HI");
        p.addScore(hi);
        assertEquals(2, p.getScore());
    }

    @Test
    public void testGetScore(){
        Player p1 = new Player(1);
        assertEquals(0, p1.getScore()); //initializes score to 0

        //for now, no other tests will pass unless setScore() is fixed
    }

    @Test
    public void testSetHand(){
        Bag b = new Bag();
        Player p = new Player(0);
        p.setHand(7);
        assertEquals(7, p.getHand().getHand().size());
    }

    @Test
    public void testGetHand(){
        Bag b = new Bag();
        Player p = new Player(0);
        Hand hand = new Hand();
        p.setHand(7);
        assertEquals(7, p.getHand().getHand().size());
        assertEquals(hand.getClass(), p.getHand().getClass());
    }

    @Test
    public void testRemoveFromHand(){
        Bag b = new Bag();
        Player p = new Player(0);
        p.setHand(7);
        assertEquals(7, p.getHand().getHand().size());

        p.remove_from_hand(p.getHand().getHand().get(0).toString());
        assertEquals(6, p.getHand().getHand().size());

        p.remove_from_hand(p.getHand().getHand().get(0).toString());
        assertEquals(5, p.getHand().getHand().size());
    }

    @Test
    public void addToHand(){
        Bag b = new Bag();
        Player p = new Player(0);
        p.setHand(3);
        assertEquals(3, p.getHand().getHand().size());

        p.add_to_hand(2);
        assertEquals(5, p.getHand().getHand().size());
        p.add_to_hand(1);
        assertEquals(6, p.getHand().getHand().size());

        // trying to add more letters than permitted to a player's hand
        p.add_to_hand(2);
        // For now, these tests do not pass because we are permitting the player to draw more letters
        assertNotEquals(8, p.getHand().getHand().size());
        assertEquals(7, p.getHand().getHand().size());
    }

}
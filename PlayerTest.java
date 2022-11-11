import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testPlayerConstructor(){
        Player p1 = new Player(1);
        assertNotNull(p1);
    }

    @Test
    public void testSetScore(){
        Player p = new Player(0);
        //p.setScore(2);
        //assertEquals(2, p.getScore());
    }

    @Test
    public void testSetHand(){
        Bag b = new Bag();
        Player p = new Player(0);
        p.setHand(7);
        // need a getter for the hand
    }

    @Test
    public void testRemoveFromHand(){
        // need a getter for the hand
    }

    @Test
    public void addToHand(){
        // need a getter for the hand
    }

    @Test
    public void playWord(){

    }

}
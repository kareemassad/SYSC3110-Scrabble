package Tests;

import Model.Letter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is testing the Letter Class
 * @author Laurence Lamarche-Cliche 101173070
 * @version 0.1
 */
public class LetterTest {

    @Test
    public void testConstructors() {
        Letter A = new Letter(Letter.Character.A);
        assertNotNull(A);

        Letter B = new Letter('B');
        assertNotNull(B);

        Letter A1 = new Letter('A');
        assertEquals(Letter.class, A1.getClass());
        assertEquals(A1.getClass(), A.getClass());
    }

    @Test
    public void testGetCharacterFromChar() {
        assertEquals(Letter.Character.class, Letter.getCharacterFromChar('L').getClass());
        assertEquals(Letter.Character.class, Letter.getCharacterFromChar('l').getClass());
    }

    @Test
    public void testGetValue() {
        Letter L = new Letter('L');
        assertEquals(1, L.getValue());

        Letter D = new Letter('D');
        Letter G = new Letter('G');
        assertEquals(2, D.getValue());
        assertEquals(D.getValue(), G.getValue());

        Letter B = new Letter('B');
        assertEquals(3, B.getValue());
    }

    @Test
    public void testSetPremium() {
    }

    @Test
    public void testGetPremium() {
    }

    @Test
    public void testToString() {
        Letter A = new Letter('A');
        Letter B = new Letter('B');
        assertEquals("A", A.toString());
        assertEquals("B", B.toString());
    }
}
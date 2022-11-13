/**
 * This is testing the Word Class
 * @author Laurence Lamarche-Cliche 101173070
 * @version 0.0
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class WordTest {

    @Test
    public void testConstructorString(){
        Word hi = new Word("hi");
        Word HI = new Word("HI");
        // verify that the letters are converted to uppercase
        assertEquals("HI", hi.toString());
        assertEquals("HI", HI.toString());

    }

    @Test
    public void testConstructorLetters(){
        Letter H = new Letter('H');
        Letter I = new Letter('I');
        ArrayList<Letter> wordLetters = new ArrayList<Letter>();
        wordLetters.add(H);
        wordLetters.add(I);
        Word word = new Word(wordLetters);
        assertNotNull(word);
        assertEquals(2, word.getLetters().size());

        ArrayList<Letter> expectedLetters = new ArrayList<Letter>();
        expectedLetters.add(H);
        expectedLetters.add(I);

        assertEquals(expectedLetters, word.getLetters()); //getLetters() have to be tested
    }

    @Test
    public void testConstructorLettersAndPremiums(){
        Letter H = new Letter('H');
        Letter O = new Letter('O');
        Letter W = new Letter('W');
        Letter L = new Letter('L');
        ArrayList<Letter> wordLetters = new ArrayList<Letter>();
        Collections.addAll(wordLetters, H, O, W, L);
        ArrayList<String> wordPremiums = new ArrayList<String>();
        Collections.addAll(wordPremiums, "NONE", "NONE", "TL", "NONE");
        Word howl = new Word(wordLetters, wordPremiums);
        assertNotNull(howl);
        assertNotNull(howl.getLetters());
        assertNotNull(howl.getPremiums());

        ArrayList<Letter> expectedLetters = new ArrayList<Letter>();
        Collections.addAll(expectedLetters, H, O, W, L);
        ArrayList<String> expectedPremiums = new ArrayList<String>();
        Collections.addAll(expectedPremiums, "NONE", "NONE", "TL", "NONE");


        assertEquals(expectedLetters, howl.getLetters());
        assertEquals(expectedPremiums, howl.getPremiums());
    }

    @Test
    public void addLetter() {
        Word course = new Word("COURSE");
        course.addLetter(course.getLetters().size(), new Letter('S'), "NONE");
        assertNotEquals("COURSE", course.toString());
        assertEquals("COURSES", course.toString());
    }

    @Test
    public void getLetters() {
        Letter C = new Letter('C');
        Letter O = new Letter('O');
        Letter U = new Letter('U');
        Letter R = new Letter('R');
        Letter S = new Letter('S');
        Letter E = new Letter('E');
        ArrayList<Letter> expectedLetters = new ArrayList<Letter>();
        Collections.addAll(expectedLetters, C, O, U, R, S, E);

        ArrayList<Letter> wordLetters = new ArrayList<Letter>();
        Collections.addAll(wordLetters, C, O, U, R, S, E);
        Word course = new Word(wordLetters);

        int i = 0;
        for (Letter letter: expectedLetters){
            assertEquals(letter, course.getLetters().get(i));
            i++;
        }

        assertEquals(expectedLetters, course.getLetters());

    }

    @Test
    public void getPremiums() {
        Letter H = new Letter('H');
        Letter O = new Letter('O');
        Letter W = new Letter('W');
        Letter L = new Letter('L');
        ArrayList<Letter> wordLetters = new ArrayList<Letter>();
        Collections.addAll(wordLetters, H, O, W, L);
        ArrayList<String> wordPremiums = new ArrayList<String>();
        Collections.addAll(wordPremiums, "NONE", "NONE", "TL", "NONE");
        Word howl = new Word(wordLetters, wordPremiums);

        ArrayList<String> expectedPremiums = new ArrayList<String>();
        Collections.addAll(expectedPremiums, "NONE", "NONE", "TL", "NONE");

        assertEquals(expectedPremiums, howl.getPremiums());
        int i = 0;
        for (String premium: expectedPremiums){
            assertEquals(premium, howl.getPremiums().get(i));
            i++;
        }
    }

    @Test
    public void getScore() {
        // for now, the word does not have a score setter method. That should be tested in Player
    }

    @Test
    public void testToString() {
        Word course = new Word("COURSE");
        assertEquals("COURSE", course.toString());

        Word tumble = new Word("Tumble");
        assertEquals("TUMBLE", tumble.toString());
    }
}
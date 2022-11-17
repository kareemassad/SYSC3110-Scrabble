package Tests;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.*;

/**
 * This is testing the Score Class
 * @author Laurence Lamarche-Cliche 101173070
 * @version 0.0
 */
/*
public class ScoreTest {
    @Test
    public void testConstructor(){
        Word hello = new Word("HELLO");
        Score score = new Score(hello);
        assertNotNull(score);
    }
    @Test
    public void testGetWordScore() {
        Word hello = new Word("HELLO");
        Score helloScore = new Score(hello);
        assertNotNull(helloScore.getWordScore());
        assertEquals(8, helloScore.getWordScore());
    }
    @Test
    public void testCalculateWord(){
        //Word hi = new Word("");
        Letter H = new Letter('H');
        Letter I = new Letter('I');
        //I.setPremium("DL");
        ArrayList<Letter> hiLetters = new ArrayList<Letter>();
        Collections.addAll(hiLetters, H, I);
        Word hi = new Word(hiLetters);
        Score hiScore = new Score(hi);
        assertEquals(5, hiScore.getWordScore());
        //test with premium implementation
        I.setPremium("DL");
        ArrayList<Letter> hiDoubleILetters = new ArrayList<Letter>();
        Collections.addAll(hiDoubleILetters, H, I);
        Word hiDoubleI = new Word(hiDoubleILetters);
        Score hiDoubleIScore = new Score(hiDoubleI);
        assertEquals(6, hiDoubleIScore.getWordScore());
    }
}
 */
package Tests;

import Model.Board;
import Model.Letter;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testConstructor(){
        Board board = new Board();
        assertNotNull(board);
        Letter[][] expected_board = new Letter[15][15];
        assertEquals(expected_board, board.get_board());
    }

    @Test
    public void place_letter() {
    }

    @Test
    public void place_word() {
    }

    @Test
    public void get_board() {
    }

    @Test
    public void store_board() {
    }
}
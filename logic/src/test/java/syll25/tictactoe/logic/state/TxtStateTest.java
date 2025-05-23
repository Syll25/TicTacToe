package syll25.tictactoe.logic.state;

import org.junit.jupiter.api.Test;
import syll25.tictactoe.logic.Board;
import syll25.tictactoe.logic.Player;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TxtStateTest {

    private static final String FILE_PATH = "gameState.txt";

    @Test
    public void testSaveAndLoad() throws IOException {

        Player player1 = new Player("John", 'X');
        Player player2 = new Player("Adam", 'O');
        int size = 3;
        Board board = new Board(size);

        board.placeSymbol(player1, 0, 0);
        board.placeSymbol(player2, 1, 1);

        TxtState state = new TxtState(FILE_PATH);

        state.save(board, player1, player2);
        StateDTO loaded = state.load();

        assertEquals("John", loaded.player1.name());
        assertEquals("X", loaded.player1.sign());
        assertEquals("Adam", loaded.player2.name());
        assertEquals("O", loaded.player2.sign());
        assertEquals(size, loaded.size);

        String[][] expectedBoard = {
                {"X", "-", "-"},
                {"-", "O", "-"},
                {"-", "-", "-"}
        };

        assertArrayEquals(expectedBoard, loaded.board);
    }

    @Test
    public void testSaveAndLoadSecondOne() throws IOException {

        Player player1 = new Player("John", 'X');
        Player player2 = new Player("Adam", 'O');
        int size = 3;
        Board board = new Board(size);

        board.placeSymbol(player1, 0, 1);
        board.placeSymbol(player2, 1, 2);
        board.placeSymbol(player1, 0, 2);
        board.placeSymbol(player2, 2, 1);

        TxtState state = new TxtState(FILE_PATH);

        state.save(board, player1, player2);
        StateDTO loaded = state.load();

        assertEquals("John", loaded.player1.name());
        assertEquals("X", loaded.player1.sign());
        assertEquals("Adam", loaded.player2.name());
        assertEquals("O", loaded.player2.sign());
        assertEquals(size, loaded.size);

        String[][] expectedBoard = {
                {"-", "X", "X"},
                {"-", "-", "O"},
                {"-", "O", "-"}
        };

        assertArrayEquals(expectedBoard, loaded.board);

    }

    @Test
    public void testSaveAndLoadThirdOne() throws IOException {

        Player player1 = new Player("John", 'X');
        Player player2 = new Player("Adam", 'O');
        int size = 3;
        Board board = new Board(size);

        board.placeSymbol(player1, 0, 1);
        board.placeSymbol(player2, 1, 2);
        board.placeSymbol(player1, 0, 2);
        board.placeSymbol(player2, 2, 1);
        board.placeSymbol(player1, 1, 1);
        board.placeSymbol(player2, 2, 0);

        TxtState state = new TxtState(FILE_PATH);

        state.save(board, player1, player2);
        StateDTO loaded = state.load();

        assertEquals("John", loaded.player1.name());
        assertEquals("X", loaded.player1.sign());
        assertEquals("Adam", loaded.player2.name());
        assertEquals("O", loaded.player2.sign());
        assertEquals(size, loaded.size);

        String[][] expectedBoard = {
                {"-", "X", "X"},
                {"-", "X", "O"},
                {"O", "O", "-"}
        };

        assertArrayEquals(expectedBoard, loaded.board);

    }

    @Test
    public void testSaveAndLoadEmptyBoard() throws IOException {

        Player player1 = new Player("John", 'X');
        Player player2 = new Player("Adam", 'O');
        int size = 3;
        Board board = new Board(size);

        TxtState state = new TxtState(FILE_PATH);

        state.save(board, player1, player2);
        StateDTO loaded = state.load();

        String[][] expectedBoard = {
                {"-", "-", "-"},
                {"-", "-", "-"},
                {"-", "-", "-"}
        };

        assertArrayEquals(expectedBoard, loaded.board);
    }

}
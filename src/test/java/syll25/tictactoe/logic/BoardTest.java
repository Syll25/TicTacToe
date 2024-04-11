package syll25.tictactoe.logic;

import org.junit.jupiter.api.Test;
import syll25.tictactoe.logic.exception.CellOccupiedException;
import syll25.tictactoe.logic.exception.InvalidMoveException;
import syll25.tictactoe.logic.exception.OutOfRangeException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void testIsFullPartiallyFilledBoard() {
        //given
        GameBoard board = new Board(3);
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');
        //when
        board.placeSymbol(player1, 0, 0);
        board.placeSymbol(player2, 1, 1);
        //then
        assertFalse(board.isFull());
    }

    @Test
    public void testIsFullEmptyBoard() {
        //given
        GameBoard board = new Board(3);
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Player2", 'Y');
        //when

        //then
        assertFalse(board.isFull());
    }

    @Test
    public void testRowWinner() {
        //given
        int size = 3;
        GameBoard board = new Board(size);
        Player player = new Player("Player", 'Z');

        //when
        try { // po co?
            for (int i = 0; i < size; i++) {
                board.placeSymbol(player, 0, i);
            }
        } catch (InvalidMoveException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        //then
        Optional<Player> winner = board.isWinner(player.getSymbol());
        assertTrue(winner.isPresent());
        assertEquals(player, winner.get());
    }

    @Test
    public void testColumnWinner() {
        //given
        int size = 3;
        GameBoard board = new Board(size);
        Player player = new Player("Player", 'X');
        //when
        try { // po co?
            for (int i = 0; i < size; i++) {
                board.placeSymbol(player, i, 0);
            }
        } catch (InvalidMoveException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        //then
        Optional<Player> winner = board.isWinner(player.getSymbol());
        winner = board.isWinner(player.getSymbol());
        assertEquals(player, winner.get());
    }

    @Test
    public void testDiagonal1Winner() {
        //given
        int size = 3;
        GameBoard board = new Board(size);
        Player player = new Player("Player", 'Y');
        //when
        try { // po co?
            for (int i = 0; i < size; i++) {
                board.placeSymbol(player, i, i);
            }
        } catch (InvalidMoveException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        //then
        Optional<Player> winner = board.isWinner(player.getSymbol());
        assertTrue(winner.isPresent());
        assertEquals(player, winner.get());
    }

    @Test
    public void testDiagonal2Winner() {
        //given
        int size = 3;
        GameBoard board = new Board(size);
        Player player = new Player("Player", 'X');
        //when
        try { // po co?
            for (int i = 0; i < size; i++) {
                board.placeSymbol(player, i, size - 1 - i);
            }
        } catch (InvalidMoveException e) {
            fail("Unexcepted exception: " + e.getMessage());
        }
        //then
        Optional<Player> winner = board.isWinner(player.getSymbol());
        assertEquals(player, winner.get());
    }

    @Test
    public void testNoWinner() {
        //given
        int size = 3;
        GameBoard board = new Board(size);
        Player player = new Player("Player", 'X');
        //when
        //then
        Optional<Player> winner = board.isWinner(player.getSymbol());
        assertFalse(winner.isPresent());
    }

    @Test
    public void testOutOfRangeException() {
        //given
        int size = 3;
        GameBoard board = new Board(size);
        Player player = new Player("Player", 'Y');
        //when
        //then
        assertThrows(OutOfRangeException.class, () -> board.placeSymbol(player, -1, 0));
        assertThrows(OutOfRangeException.class, () -> board.placeSymbol(player, -1, -1));
        assertThrows(OutOfRangeException.class, () -> board.placeSymbol(player, 0, -1));
        assertThrows(OutOfRangeException.class, () -> board.placeSymbol(player, 1, 3));
        assertThrows(OutOfRangeException.class, () -> board.placeSymbol(player, 3, 0));
        assertThrows(OutOfRangeException.class, () -> board.placeSymbol(player, size, 0));
        assertThrows(OutOfRangeException.class, () -> board.placeSymbol(player, 0, size));
    }

    @Test
    public void testCellOccupiedException() {
        //given
        int size = 3;
        GameBoard board = new Board(size);
        Player player1 = new Player("Player1", 'Z');
        Player player2 = new Player("Player2", 'Y');
        //when
        try { // po co? tym bardziej że na dole jest assertThrows
            board.placeSymbol(player1, 0, 0);
        } catch (InvalidMoveException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        //then
        assertThrows(CellOccupiedException.class, () -> board.placeSymbol(player2, 0, 0));
    }

    @Test
    public void testBoardIsFullReturnsTrue() {
        //given
        int size = 3;
        Board board = new Board(size);
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Player2", 'O');
        //when
        try { // po co?
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if ((i + j) % 2 == 0) {
                        board.placeSymbol(player1, i, j);
                    } else {
                        board.placeSymbol(player2, i, j);
                    }
                }
            }
        } catch (InvalidMoveException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        boolean isFull = board.isFull();
        assertTrue(isFull);
    }

    @Test
    public void testBoardIsFullReturnsFalse() {
        //given
        int size = 3;
        Board board = new Board(size);
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Player2", 'O');
        //when
        try { // po co?
            board.placeSymbol(player1, 0, 0);
            board.placeSymbol(player1, 1, 2);
            board.placeSymbol(player2, 2, 0);
            board.placeSymbol(player2, 0, 1);
        } catch (InvalidMoveException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        //then
        boolean isFull = board.isFull();
        assertFalse(isFull);
    }
}

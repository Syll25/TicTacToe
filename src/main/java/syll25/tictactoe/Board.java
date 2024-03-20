package syll25.tictactoe;

import java.util.Arrays;
import java.util.Optional;

public class Board {

    private final Player[][] cells;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.cells = new Player[size][size]; // czy tutaj tez utworzy sie za kazdym razem nowy uzytkownik?
        initializeBoard(cells);
    }

    public static void initializeBoard(Player[][] cells) {
        for (Player[] row : cells) {
            Arrays.fill(row, null);
        }
    }

    public int getSize() {
        return size;
    }

    public void printBoard() {

        BoardRenderer.renderBoard(cells);
    }

    public boolean isFull() {
        for (Player[] row : cells) {
            for (Player col : row) {
                if (col == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void placeSymbol(Player player, int row, int col) {
        if (row < 0 || row >= cells.length || col < 0 || col >= cells[row].length) {
            throw new InvalidMoveException("Invalid move: Out of range. ");
        }
        if (cells[row][col] != null) {
            throw new InvalidMoveException("Invalid move: Cell already occupied. ");
        }

        cells[row][col] = player;
    }

    public Optional<Player> getWinner(char symbol) {

        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (cells[i][j] == null || cells[i][j].getSymbol() != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return Optional.of(cells[i][0]);
            }
        }

        for (int j = 0; j < size; j++) {
            boolean win = true;
            for (int i = 0; i < size; i++) {
                if (cells[i][j] == null || cells[i][j].getSymbol() != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return Optional.of(cells[0][j]);
            }
        }

        boolean diagonal1Win = true;
        boolean diagonal2Win = true;

        for (int i = 0; i < size; i++) {
            if (cells[i][i] == null || cells[i][i].getSymbol() != symbol) {
                diagonal1Win = false;
            }
            if (cells[i][size - 1 - i] == null || cells[i][size - 1 - i].getSymbol() != symbol) {
                diagonal2Win = false;
            }
        }
        if (diagonal1Win) {
            return Optional.of(cells[0][0]);
        }
        if (diagonal2Win) {
            return Optional.of(cells[0][size - 1]);
        }

        return Optional.empty();
    }

}
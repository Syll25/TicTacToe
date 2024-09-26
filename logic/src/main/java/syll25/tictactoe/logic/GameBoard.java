package syll25.tictactoe.logic;

import syll25.tictactoe.logic.exception.InvalidMoveException;

import java.util.Optional;

public interface GameBoard {

    String getCell(int row, int col);

    void initializeFromState(String[][] boardState, Player player1, Player player2);

    int getSize();

    Optional<Player> getFieldState(int row, int col);

    boolean isFull();

    void placeSymbol(Player player, int row, int col) throws InvalidMoveException;

    Optional<Player> isWinner(char symbol);

    Player[][] getCells();
}
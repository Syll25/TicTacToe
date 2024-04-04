package syll25.tictactoe.logic;

import syll25.tictactoe.logic.exception.InvalidMoveException;

import java.util.Optional;

public class Board1D implements GameBoard {
  @Override
  public void initializeBoard(Player[][] cells) {

  }

  @Override
  public Player[][] getCells() {
    return new Player[0][];
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public void placeSymbol(Player player, int row, int col) throws InvalidMoveException {

  }

  @Override
  public Optional<Player> isWinner(char symbol) {
    return Optional.empty();
  }
}

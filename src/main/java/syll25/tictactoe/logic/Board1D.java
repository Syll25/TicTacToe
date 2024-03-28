package syll25.tictactoe.logic;

public class Board1D implements BoardInterface {

  private final Player[] cells;

  public Board2D(int size) {
    this.cells = new Player[size*size];
  }

  public void placeSymbol(Player player, int row, int col) {
  }
}


/*
xxxyyyzzz

xxxxxyyyyyzzzzzaaaaabbbbb

 */

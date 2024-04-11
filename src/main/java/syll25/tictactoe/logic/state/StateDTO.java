package syll25.tictactoe.logic.state;

public class StateDTO { // data transfer object

  // dane o grze wczytane z pliku - na ich podstawie utworzymy instancje Board i Player
  public String player1Name;
  public String player2Name;
  String player1Sign;
  String player2Sign;
  String[][] board;
  int size;
}

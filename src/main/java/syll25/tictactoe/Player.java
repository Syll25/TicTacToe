package syll25.tictactoe;

import java.util.Random;

public class Player {

  /*public String imie;
  public char symbol;*/

  public static int COUNTER = 0;
  public static String NAME;
  public int counter = 0;
  public String name;

  public Player() {
    COUNTER = COUNTER + 1;
    counter = COUNTER;
    NAME = "Player " + COUNTER;
    name = "Player " + COUNTER;
  }

  public Player(int a) {
  }
}



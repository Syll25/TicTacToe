package syll25.tictactoe.people;

public class Main {
  public static void main(String[] args) {
    Human manager = new Manager();
    Human cleaner = new Cleaner();
    Human boss = new Boss();

    System.out.println(manager.name());
    System.out.println(cleaner.name());
    System.out.println(boss.name());
  }
}

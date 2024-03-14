package syll25.tictactoe;

import java.util.Arrays;

// TODO przenieść do pakietu syll25.tictactoe.ui
public class BoardRenderer {
    public static void renderBoard(Player[][] cells) {
        // TODO renderowanie współrzędnych
        for (Player[] row : cells) {
            for (Player cell : row) {
                if (cell == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(cell.getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }

    public static void initializeBoard(Player[][] cells) { // to nie jest zadanie renderera, a konstruktora klasy Board
        for (Player[] row : cells) {
            Arrays.fill(row, null);
        }
    }
}

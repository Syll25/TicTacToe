package syll25.tictactoe;

import java.util.Arrays;

public class Board {

    private final char[][] board; // char, czy Player?
    private CharacterPoolRandomizer symbolChoice;

    public Board(CharacterPoolRandomizer symbolChoice) {
        this.symbolChoice = symbolChoice;
        board = new char[3][3];
    }

    public void initializeBoard() {
        for (int i=0; i< board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                /*if (board[i][j] != null) {
                    System.out.println(board[i][j].symbol);
                } else {
                    System.out.println("  ");
                }*/

                //board[i][j] = symbolChoice.drawSymbol(); // po co to? na początku będą nulle - pola planszy nie są wypełnione znakami gracza bo gra jeszcze się nie rozpoczęła
            }
        }
    }
}

/**
 * Witamy w grze kółko i krzyżyk!
 *
 * Podaj imię gracza 1:
 * john
 * John - znak X
 *
 * Podaj imię gracza 2:
 * anna
 * Anna - znak O
 *
 *  A B C
 * 1
 * 2
 * 3
 *
 * John podaj współrzędne (np. A1):
 * A1
 *
 *  A B C
 * 1X
 * 2
 * 3
 *
 * Anna podaj współrzędne (np. A1):
 * B2
 *
 *      A | B | C
 * --------------
 * 1 | X |   |   |
 * ------------
 * 2 | O |   |   |
 * -----------
 * 3 |  |    |   |
 *-------------
 */

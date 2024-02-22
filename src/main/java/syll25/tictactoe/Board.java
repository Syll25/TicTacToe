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
                board[i][j] = symbolChoice.drawSymbol(); // po co to? na początku będą nulle - pola planszy nie są wypełnione znakami gracza bo gra jeszcze się nie rozpoczęła
            }
        }
    }
}

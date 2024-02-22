package syll25.tictactoe;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CharacterPoolRandomizer symbolChoice = new CharacterPoolRandomizer('X', 'Y', 'Z', 'O', 'S');

        symbolChoice.addSymbol('X'); // nie dodajemy symboli tutaj bo przecież są one dodane w konstruktorze
        symbolChoice.addSymbol('Y');
        symbolChoice.addSymbol('O');
        symbolChoice.addSymbol('Z');
        symbolChoice.addSymbol('S');

        Board board = new Board(symbolChoice);
        board.initializeBoard(); // konstrukcja poza konstruktorem

        if(symbolChoice.availableSymbols.size() >=2) { // po prostu losujmy - jeśli coś będzie nie tak, CharacterPoolRandomizer ma rzucić wyjątek
            char player1symbol = symbolChoice.drawSymbol();
            char player2symbol = symbolChoice.drawSymbol();

            System.out.println("Player 1 that is your symbol: " + player1symbol);
            System.out.println("Player 2 that is your symbol: " + player2symbol);
        } else {
            System.out.println("Not available symbol");

        }

    }
}

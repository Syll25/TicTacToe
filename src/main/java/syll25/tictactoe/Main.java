package syll25.tictactoe;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Player player1 = new Player();
        System.out.println(player1.counter);
        System.out.println(Player.COUNTER);
        System.out.println(player1.name);

        Player player2 = new Player();
        System.out.println(player2.counter);
        System.out.println(Player.COUNTER);
        System.out.println(player2.name);

        Player player3 = new Player();
        System.out.println(player3.counter);
        System.out.println(Player.COUNTER);
        System.out.println(player3.name);

        Player player4 = new Player();
        System.out.println(player4.counter);
        System.out.println(Player.COUNTER);
        System.out.println(player4.name);


        System.out.println(Player.NAME);
    }

    public static void main2(String[] args) {

        CharacterPoolRandomizer symbolChoice = new CharacterPoolRandomizer('X', 'Y', 'Z', 'O', 'S');

        symbolChoice.addSymbol('X'); // nie dodajemy symboli tutaj bo przecież są one dodane w konstruktorze
        symbolChoice.addSymbol('Y');
        symbolChoice.addSymbol('O');
        symbolChoice.addSymbol('Z');
        symbolChoice.addSymbol('S');

        symbolChoice.drawSymbol();
        symbolChoice.drawSymbol();
        symbolChoice.drawSymbol();
        symbolChoice.drawSymbol();
        symbolChoice.drawSymbol();
        symbolChoice.drawSymbol();
        symbolChoice.drawSymbol();
        symbolChoice.drawSymbol();

        // String imie = Scanner...

        //Player player1 = new Player(symbolChoice.drawSymbol(), imie);
        Player player2 = new Player();

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

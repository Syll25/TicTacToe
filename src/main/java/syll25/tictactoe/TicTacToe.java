package syll25.tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TicTacToe { // przenieść do CharacterPoolRandomizer
    private ArrayList<Character> availableSymbols;
    private List<Character> symbols; // nadmiarowe

    public TicTacToe(char x, char y, char z, char o, char s) { // jeden argument z listą, np. char... characters (znasz operator "..."?) - patrz konstruktor niżej
        symbols = new ArrayList<>();
        symbols.add(x);
        symbols.add(y);
        symbols.add(z);
        symbols.add(o);
        symbols.add(s);

        if (symbols.size() != 5) {
            throw new IllegalArgumentException("You need to choose one of this characters: X, Y, Z, O, S"); // utwórz własny typ wyjątku
        }
        availableSymbols = new ArrayList<>(symbols);
    }

    public TicTacToe(char ...characters) {
        symbols = new ArrayList<>();
        for (char character : characters) {
            symbols.add(character);
        }

        if (symbols.size() != 5) {
            throw new IllegalArgumentException("You need to choose one of this characters: X, Y, Z, O, S"); // utwórz własny typ wyjątku
        }
        availableSymbols = new ArrayList<>(symbols);
    }

    public void addSymbols(char x, char y, char z, char o, char s) { // argumenty - patrz konstruktor
        for (char symbol : symbols) {
            availableSymbols.add(symbol);
        }
    }

    public char drawSymbol() {
        if (availableSymbols.isEmpty()) {
            throw new IllegalStateException("No available symbols"); // utwórz własny typ wyjątku
        }
        Collections.shuffle(availableSymbols); // wystarczy raz (konstruktor - od tego jest)
        char symbol = availableSymbols.remove(0);
        return symbol;
    }

    public char drawSymbol2() {
        if (availableSymbols.isEmpty()) {
            throw new IllegalStateException("No available symbols"); // utwórz własny typ wyjątku
        }
        int randomIndex = new Random().nextInt(availableSymbols.size());
        char symbol = availableSymbols.remove(randomIndex);
        return symbol;
    }

    public List<Character> drawSymbols() {
        List<Character> drawnSymbols = new ArrayList<>();
        for (char symbol : symbols) {
            drawnSymbols.add(symbol);
        }
        Collections.shuffle(drawnSymbols);
        return drawnSymbols;
    }

}

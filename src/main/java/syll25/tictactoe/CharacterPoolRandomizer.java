package syll25.tictactoe;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Wymagania:
 * - konstruktor przyjmujący zestaw znaków, z których będziemy losować
 * - metoda losująca znak z puli, bez powtórzeń
 * - metoda losująca w przypadku braku dostępnych w puli znaków rzuca wyjątek
 * - testy jednostkowe
 */
public class CharacterPoolRandomizer {
    public ArrayList<Character> availableSymbols;

    public CharacterPoolRandomizer(char... characters) {
        availableSymbols = new ArrayList<>();
        for (char c : characters) {
            availableSymbols.add(c);
        }
        Collections.shuffle(availableSymbols);
    }

    public char drawSymbol() {
        if (availableSymbols.isEmpty()) {
            throw new NoMoreSymbolsException(); // brak klasy wyjątku // brak testu na ten przypadek
        }
        return availableSymbols.remove(0);

    }

}

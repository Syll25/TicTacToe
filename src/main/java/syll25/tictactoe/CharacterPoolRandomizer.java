package syll25.tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Wymagania:
 * - konstruktor przyjmujący zestaw znaków, z których będziemy losować
 * - metoda losująca znak z puli, bez powtórzeń
 * - metoda losująca w przypadku braku dostępnych w puli znaków rzuca wyjątek
 * - testy jednostkowe
 */
public class CharacterPoolRandomizer {
    public ArrayList<Character> availableSymbols; // nie public
    public CharacterPoolRandomizer(char... characters) {
        availableSymbols = new ArrayList<>();
        for (char c : characters) {
            availableSymbols.add(c);
        }

        if (availableSymbols.size() != 5) { // po co limitujemy rozmiar puli w konstruktorze?
            // własny wyjątek
            throw new IllegalArgumentException("You need to choose one of this characters: X, Y, Z, O, S"); //nazwe wyjatku podpowiada mi program, gdy wymysle wlasna stwierdza "cannot resolve symbol"
        }
        Collections.shuffle(availableSymbols);
    }

    public void addSymbol(char symbol) { // zbędne - robi to konstruktor
            availableSymbols.add(symbol);
    }

    public char drawSymbol() {
        if (availableSymbols.isEmpty()) {
            throw new IllegalArgumentException("No available symbols"); // własny wyjątek
        }
        int randomIndex = new Random().nextInt(availableSymbols.size()); // mamy shuffle w konstruktorze
        return availableSymbols.remove(randomIndex);
    }

}

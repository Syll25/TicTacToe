package syll25.tictactoe;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
public class CharacterPoolRandomizerTest {

    @Test
    public void testDrawSymbol() {
        for (int i = 0; i < 1000; i++) {
            //given
            CharacterPoolRandomizer symbolChoice = new CharacterPoolRandomizer('X', 'Y', 'Z', 'O', 'S');
            Set<Character> availableSymbols = new HashSet<>(Arrays.asList('X', 'Y', 'Z', 'O', 'S'));

            //when
            char drawSymbol = symbolChoice.drawSymbol(); // mamy losowanie, więc by zwiększyć pewność, zróbmy to wielokrotnie

            //then
            assertTrue(drawSymbol == 'X' || drawSymbol == 'Y' || drawSymbol == 'Z' || drawSymbol == 'O' || drawSymbol == 'S');
            assertTrue(availableSymbols.contains(drawSymbol), "Symbol is not available");
        }
    }

    // TODO test na wysycenie puli
}

package syll25.tictactoe.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinatesTest {

    @Test // ok, ale dajmy jeszcze przypadki, gdy col i row są inne, oraz wyraźny test na przypadek A2 vs 2A
    public void testValidCoordinates() {
        Coordinates coordinates = new Coordinates("A1");
        assertEquals(0, coordinates.getCol());
        assertEquals(0, coordinates.getRow());

        coordinates = new Coordinates("B2");
        assertEquals(1, coordinates.getCol());
        assertEquals(1, coordinates.getRow());
    }

    // TODO test na wyjątek
}

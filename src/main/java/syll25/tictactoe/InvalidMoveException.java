package syll25.tictactoe;

// TODO przenieść do pakietu syll25.tictactoe.logic
public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(String message) {
        super(message);
    }
}

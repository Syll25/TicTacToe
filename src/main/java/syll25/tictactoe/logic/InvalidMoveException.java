package syll25.tictactoe.logic;

// TODO podpakiet exceptions
public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(String message) {
        super(message);
    }
}

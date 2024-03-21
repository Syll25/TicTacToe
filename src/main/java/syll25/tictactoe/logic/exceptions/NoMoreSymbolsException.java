package syll25.tictactoe.logic.exceptions;

// TODO podpakiet exceptions
public class NoMoreSymbolsException extends RuntimeException {
    public NoMoreSymbolsException() {
        super("No more symbols available. ");
    }
}

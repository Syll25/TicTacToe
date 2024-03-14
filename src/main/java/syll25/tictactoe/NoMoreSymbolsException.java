package syll25.tictactoe;

// TODO przenieść do pakietu syll25.tictactoe.logic
public class NoMoreSymbolsException extends RuntimeException {
    public NoMoreSymbolsException() {
        super("No more symbols available. ");
    }
}

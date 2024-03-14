package syll25.tictactoe;

import java.util.Optional;
import java.util.Arrays; // niepotrzebny import (ctrl + o)

// TODO przenieść do pakietu syll25.tictactoe.logic
public class Board {

    private final Player[][] cells = new Player[3][3]; // rozmiar jako argument konstruktora - niech Main podaje jak dużego Boarda chce
    private final CharacterPoolRandomizer symbolChoice; // do wyrzucenia?

    public Board(CharacterPoolRandomizer symbolChoice) {
        this.symbolChoice = symbolChoice;
        BoardRenderer.initializeBoard(cells); // cells to są dane które należą do klasy Board i to jej konstruktor powinien je przygotować
    }

    public void printBoard() {
        BoardRenderer.renderBoard(cells); // niech Board nic nie wie o warstwie widoku - Renderera niech wywołuje Main
    }

    public boolean isFull() {
        //nazewnictwo row/column?
        for (Player[] row : cells) {
            for (Player cell : row) {
                if (cell == null || cell.getSymbol() == '-') { // kiedy to nam zwróci '-'?
                    return false;
                }
            }
        }
        return true;
    }

    public void placeSymbol(char symbol, int row, int col) {
        /*
         oba ify razem do oddzielnej metody - private void validateMove
         komunikaty w message wyjątku zdają się być często widoku - zróbmy dedykowane, oddzielne wyjątki na te sytuacje
         Main w try/catch dla odpowiednio złapanego pokaże właściwy komunikat
         */
        if (row < 0 || row >= cells.length || col < 0 || col >= cells[0].length) {
            throw new InvalidMoveException("Invalid move: Out of range. ");
        }
        if (cells[row][col] != null) {
            throw new InvalidMoveException("Invalid move: Cell already occupied. ");
        }
        cells[row][col] = new Player(symbol); // !!!
        /*
        Do gry siada dwóch graczy.
        W Main tworzymy instancję im odpowiadające - w pamięci pojawiają się dwa obiekty klasy Player.
        Powyższa linia kodu powoduje, że w pamięci dokładamy kolejnych graczy, mimo że gra odbywa się wciąż pomiędzy dwoma graczami, którzy usiedli do gry.
         */
    }

    // TODO pokryć testami
    public Optional<Player> getWinner(char symbol) { // getWinner -> isWinner - metoda nie zwróci innego zwycięzcy niż ten, który ma symbol
        int size = cells.length;
        // tutaj wciąż jesteśmy zabetonowani z rozmiarem planszy 3x3
        for (int i = 0; i < size; i++) {
            if (cells[i][0] != null && cells[i][0].getSymbol() == symbol && cells[i][1] != null &&
                    cells[i][1].getSymbol() == symbol && cells[i][2] != null && cells[i][2].getSymbol() == symbol) {
                return Optional.of(cells[i][0]);
            }
            if (cells[0][i] != null && cells[0][i].getSymbol() == symbol && cells[1][i] != null &&
                    cells[1][i].getSymbol() == symbol && cells[2][i] != null && cells[2][i].getSymbol() == symbol) {
                return Optional.of(cells[0][i]);
            }
        }
        boolean diagonal1Win = true;
        boolean diagonal2Win = true;

        for (int i = 0; i < size; i++) {
            if (cells[i][i] == null || cells[i][i].getSymbol() != symbol) {
                diagonal1Win = false;
            }
            if (cells[i][size - 1 - i] == null || cells[i][size - 1 - i].getSymbol() != symbol) {
                diagonal2Win = false;
            }
        }
        if (diagonal1Win) {
            return Optional.of(cells[0][0]);
        }
        if (diagonal2Win) {
            return Optional.of(cells[0][size - 1]);
        }
        return Optional.empty();
    }
}

package syll25.tictactoe;

import java.util.Arrays;
import java.util.Optional;

import static java.util.Arrays.fill; // ciekawostka: import metody statycznej

public class Board {

    private final char[][] cells = new char[3][3]; // typ Player zamiast char
    private final CharacterPoolRandomizer symbolChoice;

    public Board(CharacterPoolRandomizer symbolChoice) {
        this.symbolChoice = symbolChoice;
    }

    public void initializeBoard() {
        for (char[] row : cells) {
            // niepotrzebne - niech to ma postać 0 lub null (w przypadku Player)
            // wykorzystujemy to do narysowania planszy ale wiedzieć to jest odpowiedzialnością klasy BoardRenderer
            fill(row, '-');  //nowe cudowne odkrycie z codecademy.com ale nie wiem czy dobrze użyte
        }
    }

    //        for (int i = 0; i < cells.length; i++) {
//            for (int j = 0; j < cells[i].length; j++) {
//                {
//                    cells[i][j] = '-';
//                }
//            }
//        }
//    }
    // Board nie może sam się renderować - zróbmy klasę BoardRenderer, która będzie operować na instancji klasy Board
    // brak współrzędnych
    public void printBoard() {
        for (char[] row : cells) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    //        for (int i = 0; i < cells.length; i++) {
//            for(int j = 0; j < cells[i].length; j++) {
//                System.out.print(cells[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
    // pokryć testem po poprawce związanej z '-'
    public boolean isFull() {
        for (char[] row : cells) {
            for (char cell : row) {
                if (cell == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean placeSymbol(char symbol, int row, int col) {
        if (row < 0 || row >= cells.length || col < 0 || col >= cells[0].length || cells[row][col] != '-') {
            return false; // może być, ale lepiej wyjątek zamiast boolean
        }
        cells[row][col] = symbol;
        return true;
    }

    /*
     działa dobrze dla przypadku po przekątnych?
     zahardkodowane "3"
     ma działać także dla tablicy 5x5, 10x10 itd
     pokryć testem
     nazewnictwo - metoda nie sprawdza kto wygrał, a czy wygrał wskazany - zmieńmy na Optional<Player> getWinner()
     znać Optional
     */
    public boolean checkWhoWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((cells[i][0] == symbol && cells[i][1] == symbol && cells[i][2] == symbol) ||
                    (cells[0][i] == symbol && cells[1][i] == symbol && cells[2][i] == symbol)) {
                //return Optional.of(player); // gdy jest zwycieżca
                return true;
            }
        }

        //return Optional.empty(); // gdy brak zwycięzcy
        return false;
        //w Main np.
//        Optional<Player> winner = getWinner();
//        if (winner.isPresent())
    }
}

package syll25.tictactoe;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CharacterPoolRandomizer symbolChoice = new CharacterPoolRandomizer('X', 'Y', 'Z', 'O', 'S');

        Board board = new Board();
        System.out.println("That is your game board: ");
        board.printBoard();

        if (symbolChoice.availableSymbols.size() >= 2) {
            Player player1 = new Player(symbolChoice.drawSymbol());
            Player player2 = new Player(symbolChoice.drawSymbol());

            System.out.println("Player 1 that is your symbol: " + player1.getSymbol());
            System.out.println("Player 2 that is your symbol: " + player2.getSymbol());

            Scanner scanner = new Scanner(System.in);
            boolean gameOver = false;

            while (!gameOver) {
                gameOver = playerMove(board, scanner, player1);
                if (gameOver) break;
                gameOver = playerMove(board, scanner, player2);
            }
        } else {
            System.out.println("Not available symbol");

        }
    }

    public static boolean playerMove(Board board, Scanner scanner, Player player) {
        int row, col;

        System.out.println("Player, enter row and column (e.g. A1, B2): ");
        do {
            String input = scanner.nextLine().toUpperCase();
            if (input.length() != 2) {
                System.out.println("Invalid input. Please enter row and column in the format A1, B2 etc.");
                continue;
            }
            char rowChar = input.charAt(0);
            char colChar = input.charAt(1);

            if (!(rowChar >= 'A' && rowChar <= 'C') || !(colChar >= '1' && colChar <= '3')) {
                System.out.println("Invalid input. Please enter row (A-C) and column (1-3)");
                continue;
            }
            row = convertRowInput(rowChar);
            col = convertColumnInput(colChar);

            try {
                board.placeSymbol(player, row, col);
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        } while (true);

        board.printBoard();

        Optional<Player> winner = board.getWinner(player.getSymbol());
        if (winner.isPresent()) {
            System.out.println("Player " + player.getSymbol() + " wins!");
            return true;
        } else if (board.isFull()) {
            System.out.println("We have a draw!");
            return true;
        }

        return false;
    }

    private static int convertRowInput(char input) {
        switch (input) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            default:
                throw new IllegalArgumentException("Invalid row input: " + input);
        }
    }

    private static int convertColumnInput(char input) {
        switch (input) {
            case '1':
                return 0;
            case '2':
                return 1;
            case '3':
                return 2;
            default:
                throw new IllegalArgumentException("Invalid column input: " + input);
        }
    }


}



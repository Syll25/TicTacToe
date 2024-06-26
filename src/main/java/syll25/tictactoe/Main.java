package syll25.tictactoe;

import syll25.tictactoe.logic.*;
import syll25.tictactoe.logic.exception.*;
import syll25.tictactoe.ui.BoardRenderer;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static int boardSize = 3;

    public static void main(String[] args) {

        CharacterPoolRandomizer symbolChoice = new CharacterPoolRandomizer('X', 'Y', 'Z', 'O', 'S');

        Scanner scanner = new Scanner(System.in);

        System.out.println("Player 1, enter your name: ");
        String player1Name = scanner.nextLine();
        System.out.println("Player 2, enter your name");
        String player2Name = scanner.nextLine();

        Board board = new Board(boardSize);
        System.out.println("That is your game board: ");

        BoardRenderer.renderBoard(board.getCells());

        try {
            Player player1 = new Player(player1Name, symbolChoice.drawSymbol());
            Player player2 = new Player(player2Name, symbolChoice.drawSymbol());

            System.out.println("Player " + player1.getName() + " that is your symbol: " + player1.getSymbol());
            System.out.println("Player " + player2.getName() + " that is your symbol: " + player2.getSymbol());

            boolean gameOver = false;

            while (!gameOver) {
                System.out.println(player1.getName() + " , enter row and column (e.g. A1, B2): ");
                gameOver = playerMove(board, scanner, player1);
                if (gameOver) break;
                System.out.println(player2.getName() + " , enter row and column (e.g. A1, B2): ");
                gameOver = playerMove(board, scanner, player2);
            }
        } catch (NoMoreSymbolsException ex) {
            System.out.println("No more symbols available. ");
        }
    }

    public static boolean playerMove(Board board, Scanner scanner, Player player) {
        int row, col;
        String input;

        do {
            input = scanner.nextLine().toUpperCase();
            Coordinates coordinates = new Coordinates(input);

            row = coordinates.getRow();
            col = coordinates.getCol();

            if (row == -1 || col == -1) {
                System.out.println("Invalid input. Please enter row and column in the format A1, B2, etc.");
                continue;
            }

            try {
                board.placeSymbol(player, row, col);
            } catch (InvalidMoveException ex) {
                System.out.println(ex.getMessage());
                continue;
            } catch (OutOfRangeException ex) {
                System.out.println("Invalid move: Out of range. ");
                continue;
            } catch (CellOccupiedException ex) {
                System.out.println("Invalid move: Cell already occupied. ");
                continue;
            } catch (InvalidCoordinatesException ex) {
                System.out.println("Invalid input. Please enter row and column in the format A1, B2 etc. ");
                continue;
            }
            break;
        } while (true);
        BoardRenderer.renderBoard(board.getCells());

        Optional<Player> winner = board.isWinner(player.getSymbol());
        if (winner.isPresent()) {
            System.out.println(player.getName() + player.getSymbol() + " wins!");
            return true;
        } else if (board.isFull()) {
            System.out.println("We have a draw!");
            return true;
        }
        return false;
    }
}




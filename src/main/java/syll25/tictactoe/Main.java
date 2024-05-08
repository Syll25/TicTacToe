package syll25.tictactoe;

import syll25.tictactoe.logic.*;
import syll25.tictactoe.logic.exception.*;
import syll25.tictactoe.logic.state.State;
import syll25.tictactoe.logic.state.StateDTO;
import syll25.tictactoe.logic.state.TxtState;
import syll25.tictactoe.ui.BoardRenderer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static int boardSize = 3;
    private static Player player1;
    private static Player player2;

    public static void main(String[] args) {
        String filename = getGameStateFileName(args);

        if (args.length == 0) {
            System.out.println("Usage: java Main <gameState.txt>");
            return;
        }

        Path path = Paths.get(filename);

        if (!Files.exists(path)) {
            System.out.println("File can not be founded");
            return;
        }

        State state = new TxtState(filename);
        StateDTO stateDTO = state.load();

        if (stateDTO != null) {
            loadExistingGames(state, stateDTO);
        } else {
            System.out.println("No saved game state found. Starting a new game.");
            startNewGame(filename);
        }
    }

    private static String getGameStateFileName(String[] args) {
        if (args.length == 1) {
            return args[0];
        } else {
            LocalDateTime.now();
            // TODO skonwertuj na format: rok-miesiac-dzien_godzina-minuta-sekunda-milisekunda i zwróć
        }
    }

    public static void loadExistingGames(State state, StateDTO stateDTO) {

        String player1Name = stateDTO.player1Name;
        String player2Name = stateDTO.player2Name;
        String player1Sign = stateDTO.player1Sign;
        String player2Sign = stateDTO.player2Sign;

        Player player1 = new Player(player1Name, player1Sign.charAt(0));
        Player player2 = new Player(player2Name, player2Sign.charAt(0));

        GameBoard board = new Board(stateDTO.size);
        board.initializeFromState(stateDTO.board, player1, player2);

        System.out.println("Loaded game board: ");
        BoardRenderer.renderBoard(board);

        playGame(state, board, player1, player2);
    }

    public static void startNewGame(String filename) {

        CharacterPoolRandomizer symbolChoice = new CharacterPoolRandomizer('X', 'Y', 'Z', 'O', 'S');

        Scanner scanner = new Scanner(System.in);

        System.out.println("Player 1, enter your name: ");
        String player1Name = scanner.nextLine();
        System.out.println("Player 2, enter your name");
        String player2Name = scanner.nextLine();

        GameBoard board = new Board(boardSize);
        System.out.println("That is your game board: ");

        BoardRenderer.renderBoard(board);

        try {
            player1 = new Player(player1Name, symbolChoice.drawSymbol());
            player2 = new Player(player2Name, symbolChoice.drawSymbol());
            System.out.println("Player " + player1.getName() + " that is your symbol: " + player1.getSymbol());
            System.out.println("Player " + player2.getName() + " that is your symbol: " + player2.getSymbol());

            playGame(new TxtState((filename)), board, player1, player2);

        } catch (NoMoreSymbolsException ex) {
            System.out.println("No more symbols available. ");
        }
    }

    private static void playGame(State state, GameBoard board, Player player1, Player player2) {
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println(player1.getName() + " , enter row and column (e.g. A1, B2): ");
            gameOver = playerMove(state, board, new Scanner(System.in), player1);
            if (gameOver) break;
            System.out.println(player2.getName() + " , enter row and column (e.g. A1, B2): ");
            gameOver = playerMove(state, board, new Scanner(System.in), player2);
        }

    }


    public static boolean playerMove(State state, GameBoard board, Scanner scanner, Player player) {
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

        BoardRenderer.renderBoard(board);

        state.save(board, Main.player1, Main.player2); // odnoszenie sie do zmiennych statycznych klasy main?

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



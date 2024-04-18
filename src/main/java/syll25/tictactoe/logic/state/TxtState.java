package syll25.tictactoe.logic.state;

import syll25.tictactoe.logic.GameBoard;
import syll25.tictactoe.logic.Player;

import java.io.*;

public class TxtState implements State {
    @Override
    public void save(GameBoard board, Player player1, Player player2) {

      try {
        PrintStream consoleWriter = System.out;

        consoleWriter.println("Zapisuje stan gry do pliku");

        PrintWriter out = new PrintWriter(new FileWriter("gameState.txt"));
        out.write(player1.getName());
        out.write(":");
        out.write(player1.getSymbol());
        out.write(";");
        out.write(player2.getName());
        out.write(":");
        out.write(player2.getSymbol());
        out.close();
      } catch (IOException e) {
        //throw new FileWriteError(e);
      }

    }

    @Override
    public StateDTO load(String filename) {  //DTO Data Transfer Object

        StateDTO stateDTO = new StateDTO();

        try {
          BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
          String line1 = reader.readLine();
          String line2 = reader.readLine();
          reader.close();
          String[] players = line1.split(";");
          String[] playerData1 = players[0].split(":");
          stateDTO.player1Name = playerData1[0];
          stateDTO.player1Sign = playerData1[1];
          int size = (int) Math.sqrt(line2.length());




          String[][] board = new String[size][size];
          //String[][] board2 = board;




          for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
              char character = line2.charAt(i * size + j);
              if (character != '-')
                board[i][j] = String.valueOf(character);
            }
          }
          stateDTO.board = board;


          System.out.println();
        }catch (IOException e) {
          //throw new FileReadError(e);
        }

        //String fileContent = ;


//        stateDTO.player1Name = filename.split(";")
//        stateDTO.player2Name =

        return stateDTO;
    }

}

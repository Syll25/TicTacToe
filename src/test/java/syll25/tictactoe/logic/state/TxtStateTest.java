package syll25.tictactoe.logic.state;

import org.junit.jupiter.api.Test;
import syll25.tictactoe.logic.Player;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TxtStateTest {

   @Test
   public void testSaveAndLoad() throws IOException {
//       StateDTO stateDTO = new StateDTO("Sylwia", "Ania", 'X', 'S',null,3);
       TxtState state = new TxtState();
//       String filename = "GameState";

//     Player player1 = new Player("John", 'x');
//     Player player2 = new Player("Adam", 'o');
//     state.save(null, player1, player2);



       StateDTO loaded = state.load("gameState.txt");
//
//       assertEquals(stateDTO.player1Name, loaded.player1Name);
//       assertEquals(stateDTO.player2Name, loaded.player2Name);
//       assertEquals(stateDTO.player1Sign, loaded.player1Sign);
//       assertEquals(stateDTO.player2Sign, loaded.player2Sign);
//       assertEquals(stateDTO.size, loaded.size);

   }

}

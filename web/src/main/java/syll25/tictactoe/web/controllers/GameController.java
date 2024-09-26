package syll25.tictactoe.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import syll25.tictactoe.logic.Board;
import syll25.tictactoe.web.service.GameService;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/start")
    public String startNewGame(@RequestParam String player1Name, @RequestParam String player2Name) {
        String filename = "new_game";
        Board board = gameService.startNewGame(filename);
        String name;
        //return "New game started between " + player1Name + " and " + player2Name;
        return "start.html"; // thymeleaf - musi dostać board
    }

    @PostMapping("/playerMove")
    public String playerMove(@RequestParam int x, @RequestParam int y) {
        gameService.playerMove(x, y);
    }

    @PostMapping("/load")
    public String loadGame(@RequestParam String filename) {
        gameService.loadGame(filename);
        return "Game loaded from " + filename;
    }

    @GetMapping("/list-games")
    public String listGames() {
        return gameService.listGames();
    }

}

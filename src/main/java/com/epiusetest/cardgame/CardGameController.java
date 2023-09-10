package com.epiusetest.cardgame;

import com.epiusetest.game.FiveCardDraw;
import com.epiusetest.game.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller to be implemented when extending to a web application:
@RestController
@RequestMapping("/api/cardgame")
public class CardGameController {

    private final Game game;

    // Initialize the game type:
    public CardGameController() {
        System.out.println("Game instantiated in the controller");
        this.game = new FiveCardDraw();
        System.out.println("Ignored for now...");
    }

    // Play the game and return the result;
    @GetMapping("/play")
    public String playGame() {

        return game.play();
    }
}

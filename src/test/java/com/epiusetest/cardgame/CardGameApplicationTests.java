package com.epiusetest.cardgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.epiusetest.game.FiveCardDraw;
import com.epiusetest.game.Game;


import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
class CardGameApplicationTests {

    @DisplayName("Test accurate Play return of a FiveCardDraw game")
    @Test
    public void CardGameApplicationTest_FiveCardDraw() {
        Game myGame = new FiveCardDraw();
        String result = myGame.play();
        assertTrue(result.equals("Ranking: Straight Flush")
                || result.equals("Ranking: Four of a kind")
                || result.equals("Ranking: Full House")
                || result.equals("Ranking: Flush")
                || result.equals("Ranking: Straight")
                || result.equals("Ranking: Three of a kind")
                || result.equals("Ranking: Two Pair")
                || result.equals("Ranking: One Pair")
                || result.equals("Ranking: High Card"));
    }

}

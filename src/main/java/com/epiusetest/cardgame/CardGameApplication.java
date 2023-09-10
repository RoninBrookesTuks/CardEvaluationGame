package com.epiusetest.cardgame;

import com.epiusetest.game.FiveCardDraw;
import com.epiusetest.game.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardGameApplication {

    //Initialize game type:
    public static void main(String[] args) {
        SpringApplication.run(CardGameApplication.class, args);
        System.out.println("\n------------------------------------------\n");
        Game mygame = new FiveCardDraw();
        System.out.println(mygame.play());
        System.out.println("\n------------------------------------------\n");
        System.exit(0);
    }

}

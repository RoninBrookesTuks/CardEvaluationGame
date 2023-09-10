package com.epiusetest.game;

import com.epiusetest.deck.Deck;
import com.epiusetest.hand.Hand;

public abstract class Game {

    //player's hand:
    Hand playerHand;

    //players deck:
    Deck playerDeck;

    //Game base class empty constructor:
    public Game() {}

    //Template method to call the specific Identify() function:
    public final String play() {
            playerDeck.shuffle();
            playerDeck.deal(playerHand);
            System.out.println(playerHand.viewHand());
            return identifyRank();
    }

    //Template method for testing specific hands
    public final String play(Hand testHand){
        playerHand=testHand;
        return identifyRank();
    }

    //Primitive function implemented in derived classes:
     protected abstract String identifyRank();

}

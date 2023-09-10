package com.epiusetest.deck;

import com.epiusetest.card.Card;
import com.epiusetest.hand.Hand;
import java.util.logging.Logger;
import java.util.logging.Level;

import java.util.ArrayList;
import java.util.Random;

public abstract class Deck {

    //Cards in your deck:
    ArrayList<Card> deckCards;

    //Ranks in value order
    ArrayList<String> cardRanks;

    //Logger variable to log specific errors details:
    final private Logger logger = Logger.getLogger(Deck.class.getName());

    //Calls the method to set up the rankings of the cards of the deck:
    public Deck() {
        cardRankSetter();
    }

    //Shuffle the cards in the deck:
    public void shuffle() {
        if (deckCards.isEmpty()) {
            String errorMessage = "shuffle(): Deck size must be at least 1";
            logger.log(Level.SEVERE, errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        System.out.println("Shuffling cards...");
        Random randomIndex = new Random();
        for (int i = 0; i < deckCards.size(); i++) {
            // establish random position:
            int r = i + randomIndex.nextInt(deckCards.size() - i);
            //swap current position with random position:
            Card temp = deckCards.get(r);
            deckCards.set(r, deckCards.get(i));
            deckCards.set(i, temp);
        }
    }

    //Deal a hand of cards to the player's hand:
    public void deal(Hand playerHand) {
        if (deckCards.isEmpty()) {
            String errorMessage = "deal(hand playerHand): Deck size must be at least 1";
            logger.log(Level.SEVERE, errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        if (playerHand.getHandSize()<=0) {
            String errorMessage = "deal(hand playerHand): Hand size must be at least 1";
            logger.log(Level.SEVERE, errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        System.out.println("Dealing cards...");
        for (int i = 0; i < playerHand.getHandSize(); i++) {
            playerHand.drawCard(deckCards.remove(0));
        }
    }

    //Sets the rank values in any deck:
    protected abstract void cardRankSetter();

}

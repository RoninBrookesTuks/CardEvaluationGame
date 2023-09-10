package com.epiusetest.hand;

import com.epiusetest.card.Card;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hand {

    //cards in your hand:
    private final ArrayList<Card> handCards;

    //size of your hand:
    private final int sizeOfHand;

    //Logger variable to log specific errors details:
    final private Logger logger = Logger.getLogger(Hand.class.getName());

    //Initialize hand and size of hand:
    public Hand(int sizeOfHand) {
        handCards = new ArrayList<>();
        this.sizeOfHand = sizeOfHand;
    }

    //Returns hand details:
    public String viewHand() {
        if (handCards.isEmpty()) {
            String errorMessage = "viewHand(): Hand size must be at least 1";
            logger.log(Level.SEVERE, errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        StringBuilder handDetails = new StringBuilder("Your hand: ");
        for (Card card : handCards) {
            handDetails.append(card.getDetails());
            handDetails.append(",");
        }
        handDetails.deleteCharAt(handDetails.length() - 1);
        return handDetails.toString();
    }

    //Return hand size:
    public int getHandSize() {
        return sizeOfHand;
    }

    //Add a specific card to hand:
    public void drawCard(Card drawnCard) {
        handCards.add(drawnCard);
    }

    //Return cards in hand:
    public ArrayList<Card> getCards() {
        return handCards;
    }
}

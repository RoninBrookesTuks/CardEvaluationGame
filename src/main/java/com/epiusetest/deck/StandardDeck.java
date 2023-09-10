package com.epiusetest.deck;

import com.epiusetest.card.Card;

import java.util.ArrayList;

public class StandardDeck extends Deck {

    //Amount of ranks in a standardDeck:
    final int amountOfRanks = 13;

    //Lowest numbered rank value of a standard deck:
    final int numberRanks_lowBound = 2;

    //Highest numbered rank value of a standard deck:
    final int numberRanks_highBound = 11;

    //Initialize deck cards:
    public StandardDeck() {
        deckCards = new ArrayList<>();
        for (int i = 0; i < amountOfRanks; i++) {
            deckCards.add(new Card(cardRanks.get(i),"Hearts"));
            deckCards.add(new Card(cardRanks.get(i),"Diamonds"));
            deckCards.add(new Card(cardRanks.get(i),"Clubs"));
            deckCards.add(new Card(cardRanks.get(i),"Spades"));
        }
    }

    //instantiate and initialize the ranking for the cards of the deck:
    @Override
    protected void cardRankSetter(){
        cardRanks = new ArrayList<>();
        for (int i = numberRanks_lowBound; i < numberRanks_highBound; i++) {
            cardRanks.add(Integer.toString(i));
        }
        cardRanks.add("J");
        cardRanks.add("Q");
        cardRanks.add("K");
        cardRanks.add("A");
    }

}

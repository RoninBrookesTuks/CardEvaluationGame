package com.epiusetest.deck;

import com.epiusetest.card.Card;
import com.epiusetest.hand.Hand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StandardDeckTests {

    private Deck mockDeck;
    private Hand mockPlayerHand;

    @BeforeEach
    public void setUp() {
        // Initialize a new deck before each test
        mockDeck = new StandardDeck();
    }

    @DisplayName("Tests that the deal exception works")
    @Test
    public void dealTest_invalidHandSize(){
        mockPlayerHand = new Hand(0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> mockDeck.deal(mockPlayerHand));
        assertEquals("deal(hand playerHand): Hand size must be at least 1",
                exception.getMessage());
    }

    @DisplayName("Tests if the deck is properly initialized with 52 cards")
    @Test
    public void standardDeckTest() {
        Assertions.assertEquals(52, mockDeck.deckCards.size());
    }

    //Return deck details for testing deck functionality:
    public String viewDeck(){
        if (mockDeck.deckCards.isEmpty()) {
            String errorMessage = "viewDeck: Deck size must be at least 1";
            throw new IllegalArgumentException(errorMessage);
        }
        StringBuilder deckDetails= new StringBuilder("The deck:\n");
        for (Card deckCard : mockDeck.deckCards) {
            deckDetails.append(deckCard.getDetails());
            deckDetails.append(" ");
        }
        return deckDetails.toString();
    }

    @DisplayName("Tests if viewDeck returns the right deck structure")
    @Test
    public void viewDeckTest(){

        Assertions.assertEquals("The deck:\n"+
                "2-Hearts 2-Diamonds 2-Clubs 2-Spades "+
                "3-Hearts 3-Diamonds 3-Clubs 3-Spades "+
                "4-Hearts 4-Diamonds 4-Clubs 4-Spades "+
                "5-Hearts 5-Diamonds 5-Clubs 5-Spades "+
                "6-Hearts 6-Diamonds 6-Clubs 6-Spades "+
                "7-Hearts 7-Diamonds 7-Clubs 7-Spades "+
                "8-Hearts 8-Diamonds 8-Clubs 8-Spades "+
                "9-Hearts 9-Diamonds 9-Clubs 9-Spades "+
                "10-Hearts 10-Diamonds 10-Clubs 10-Spades "+
                "J-Hearts J-Diamonds J-Clubs J-Spades " +
                "Q-Hearts Q-Diamonds Q-Clubs Q-Spades " +
                "K-Hearts K-Diamonds K-Clubs K-Spades " +
                "A-Hearts A-Diamonds A-Clubs A-Spades ",viewDeck());
    }

    @DisplayName("Tests the shuffle method")
    @Test
    public void shuffleTest() {
        // Shuffle the original deck and ensure it's different from an un-shuffled standard deck
        mockDeck.shuffle();
        Assertions.assertNotEquals("The deck:\n"+
                "2-Hearts 2-Diamonds 2-Clubs 2-Spades "+
                "3-Hearts 3-Diamonds 3-Clubs 3-Spades "+
                "4-Hearts 4-Diamonds 4-Clubs 4-Spades "+
                "5-Hearts 5-Diamonds 5-Clubs 5-Spades "+
                "6-Hearts 6-Diamonds 6-Clubs 6-Spades "+
                "7-Hearts 7-Diamonds 7-Clubs 7-Spades "+
                "8-Hearts 8-Diamonds 8-Clubs 8-Spades "+
                "9-Hearts 9-Diamonds 9-Clubs 9-Spades "+
                "10-Hearts 10-Diamonds 10-Clubs 10-Spades "+
                "J-Hearts J-Diamonds J-Clubs J-Spades " +
                "Q-Hearts Q-Diamonds Q-Clubs Q-Spades " +
                "K-Hearts K-Diamonds K-Clubs K-Spades " +
                "A-Hearts A-Diamonds A-Clubs A-Spades ",viewDeck());
    }

    @DisplayName("Tests that deal() draws the first handful of cards")
    @Test
    public void dealTest(){
        mockPlayerHand = new Hand(5);
        mockDeck.deal(mockPlayerHand);
        Assertions.assertEquals("2-Hearts",mockPlayerHand.getCards().get(0).getDetails());
        Assertions.assertEquals("2-Diamonds",mockPlayerHand.getCards().get(1).getDetails());
        Assertions.assertEquals("2-Clubs",mockPlayerHand.getCards().get(2).getDetails());
        Assertions.assertEquals("2-Spades",mockPlayerHand.getCards().get(3).getDetails());
        Assertions.assertEquals("3-Hearts",mockPlayerHand.getCards().get(4).getDetails());
    }

}


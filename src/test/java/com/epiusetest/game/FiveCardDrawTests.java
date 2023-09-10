package com.epiusetest.game;


import com.epiusetest.card.Card;
import com.epiusetest.hand.Hand;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FiveCardDrawTests {

    private Hand mockPlayerHand;
    private Game mockGame;

    @BeforeEach
    public void setup() {
        mockPlayerHand = new Hand(5);
        mockGame = new FiveCardDraw();
    }

    @DisplayName("Tests exception handling with incorrect handSize")
    @Test
    public void playTest_invalidHandSize(){
        mockPlayerHand = new Hand(1);
        mockPlayerHand.drawCard(new Card("J","Spades"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> mockGame.play(mockPlayerHand));
        assertEquals("identifyRank(): Hand size for FiveCardDraw is not 5 cards",
                exception.getMessage());
    }

    @DisplayName("Tests straight flush accuracy with hearts suit")
    @Test
    public void isStraightFlushTest_hearts() {
        mockPlayerHand.drawCard(new Card("Q", "Hearts"));
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        mockPlayerHand.drawCard(new Card("10", "Hearts"));
        mockPlayerHand.drawCard(new Card("9", "Hearts"));
        mockPlayerHand.drawCard(new Card("8", "Hearts"));
        Assertions.assertEquals("Ranking: Straight Flush", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests straight flush accuracy with diamonds suit")
    @Test
    public void isStraightFlushTest_diamonds() {
        mockPlayerHand.drawCard(new Card("A", "Diamonds"));
        mockPlayerHand.drawCard(new Card("K", "Diamonds"));
        mockPlayerHand.drawCard(new Card("Q", "Diamonds"));
        mockPlayerHand.drawCard(new Card("J", "Diamonds"));
        mockPlayerHand.drawCard(new Card("10", "Diamonds"));
        Assertions.assertEquals("Ranking: Straight Flush", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests straight flush accuracy with clubs suit")
    @Test
    public void isStraightFlushTest_clubs() {
        mockPlayerHand.drawCard(new Card("6", "Clubs"));
        mockPlayerHand.drawCard(new Card("5", "Clubs"));
        mockPlayerHand.drawCard(new Card("4", "Clubs"));
        mockPlayerHand.drawCard(new Card("3", "Clubs"));
        mockPlayerHand.drawCard(new Card("2", "Clubs"));
        Assertions.assertEquals("Ranking: Straight Flush", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests straight flush accuracy with spades suit")
    @Test
    public void isStraightFlushTest_spades() {
        mockPlayerHand.drawCard(new Card("5", "Spades"));
        mockPlayerHand.drawCard(new Card("6", "Spades"));
        mockPlayerHand.drawCard(new Card("7", "Spades"));
        mockPlayerHand.drawCard(new Card("8", "Spades"));
        mockPlayerHand.drawCard(new Card("9", "Spades"));
        Assertions.assertEquals("Ranking: Straight Flush", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Four of a kind accuracy with first 4 cards")
    @Test
    public void isFourOfaKindTest_first() {
        mockPlayerHand.drawCard(new Card("9", "Spades"));
        mockPlayerHand.drawCard(new Card("9", "Hearts"));
        mockPlayerHand.drawCard(new Card("9", "Diamonds"));
        mockPlayerHand.drawCard(new Card("9", "Spades"));
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        Assertions.assertEquals("Ranking: Four of a kind", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Four of a kind accuracy with last 4 cards")
    @Test
    public void isFourOfaKindTest_last() {
        mockPlayerHand.drawCard(new Card("J", "Spades"));
        mockPlayerHand.drawCard(new Card("9", "Hearts"));
        mockPlayerHand.drawCard(new Card("9", "Diamonds"));
        mockPlayerHand.drawCard(new Card("9", "Spades"));
        mockPlayerHand.drawCard(new Card("9", "Hearts"));
        Assertions.assertEquals("Ranking: Four of a kind", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Four of a kind accuracy with mix of 4 cards")
    @Test
    public void isFourOfaKindTest_mix() {
        mockPlayerHand.drawCard(new Card("9", "Spades"));
        mockPlayerHand.drawCard(new Card("9", "Hearts"));
        mockPlayerHand.drawCard(new Card("9", "Diamonds"));
        mockPlayerHand.drawCard(new Card("J", "Spades"));
        mockPlayerHand.drawCard(new Card("9", "Hearts"));
        Assertions.assertEquals("Ranking: Four of a kind", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Full house accuracy with first 3 cards")
    @Test
    public void isFullHouseTest_first() {
        mockPlayerHand.drawCard(new Card("9", "Spades"));
        mockPlayerHand.drawCard(new Card("9", "Hearts"));
        mockPlayerHand.drawCard(new Card("9", "Diamonds"));
        mockPlayerHand.drawCard(new Card("J", "Spades"));
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        Assertions.assertEquals("Ranking: Full House", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Full house accuracy with last 3 cards")
    @Test
    public void isFullHouseTest_last() {
        mockPlayerHand.drawCard(new Card("J", "Spades"));
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        mockPlayerHand.drawCard(new Card("9", "Diamonds"));
        mockPlayerHand.drawCard(new Card("9", "Spades"));
        mockPlayerHand.drawCard(new Card("9", "Hearts"));
        Assertions.assertEquals("Ranking: Full House", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Full house accuracy with mix of 3 cards")
    @Test
    public void isFullHouseTest_mix() {
        mockPlayerHand.drawCard(new Card("9", "Spades"));
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        mockPlayerHand.drawCard(new Card("9", "Diamonds"));
        mockPlayerHand.drawCard(new Card("J", "Spades"));
        mockPlayerHand.drawCard(new Card("9", "Hearts"));
        Assertions.assertEquals("Ranking: Full House", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Flush accuracy with hearts suit")
    @Test
    public void isFlushTest_hearts() {
        mockPlayerHand.drawCard(new Card("Q", "Hearts"));
        mockPlayerHand.drawCard(new Card("2", "Hearts"));
        mockPlayerHand.drawCard(new Card("4", "Hearts"));
        mockPlayerHand.drawCard(new Card("10", "Hearts"));
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        Assertions.assertEquals("Ranking: Flush", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Flush accuracy with diamonds suit")
    @Test
    public void isFlushTest_diamonds() {
        mockPlayerHand.drawCard(new Card("Q", "Diamonds"));
        mockPlayerHand.drawCard(new Card("2", "Diamonds"));
        mockPlayerHand.drawCard(new Card("4", "Diamonds"));
        mockPlayerHand.drawCard(new Card("10", "Diamonds"));
        mockPlayerHand.drawCard(new Card("J", "Diamonds"));
        Assertions.assertEquals("Ranking: Flush", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Flush accuracy with clubs suit")
    @Test
    public void isFlushTest_clubs() {
        mockPlayerHand.drawCard(new Card("Q", "Clubs"));
        mockPlayerHand.drawCard(new Card("2", "Clubs"));
        mockPlayerHand.drawCard(new Card("4", "Clubs"));
        mockPlayerHand.drawCard(new Card("10", "Clubs"));
        mockPlayerHand.drawCard(new Card("J", "Clubs"));
        Assertions.assertEquals("Ranking: Flush", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Flush accuracy with spades suit")
    @Test
    public void isFlushTest_spades() {
        mockPlayerHand.drawCard(new Card("Q", "Spades"));
        mockPlayerHand.drawCard(new Card("2", "Spades"));
        mockPlayerHand.drawCard(new Card("4", "Spades"));
        mockPlayerHand.drawCard(new Card("10", "Spades"));
        mockPlayerHand.drawCard(new Card("J", "Spades"));
        Assertions.assertEquals("Ranking: Flush", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Straight accuracy with ascending order")
    @Test
    public void isStraightTest_ascending() {
        mockPlayerHand.drawCard(new Card("6", "Hearts"));
        mockPlayerHand.drawCard(new Card("7", "Spades"));
        mockPlayerHand.drawCard(new Card("8", "Hearts"));
        mockPlayerHand.drawCard(new Card("9", "Spades"));
        mockPlayerHand.drawCard(new Card("10", "Clubs"));
        Assertions.assertEquals("Ranking: Straight", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Straight accuracy with descending order")
    @Test
    public void isStraightTest_descending() {
        mockPlayerHand.drawCard(new Card("A", "Hearts"));
        mockPlayerHand.drawCard(new Card("K", "Spades"));
        mockPlayerHand.drawCard(new Card("Q", "Hearts"));
        mockPlayerHand.drawCard(new Card("J", "Spades"));
        mockPlayerHand.drawCard(new Card("10", "Clubs"));
        Assertions.assertEquals("Ranking: Straight", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Three of a kind accuracy with first 3 cards")
    @Test
    public void isThreeOfaKindTest_first() {
        mockPlayerHand.drawCard(new Card("A", "Hearts"));
        mockPlayerHand.drawCard(new Card("A", "Spades"));
        mockPlayerHand.drawCard(new Card("A", "Hearts"));
        mockPlayerHand.drawCard(new Card("J", "Spades"));
        mockPlayerHand.drawCard(new Card("10", "Clubs"));
        Assertions.assertEquals("Ranking: Three of a kind", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Three of a kind accuracy with last 3 cards")
    @Test
    public void isThreeOfaKindTest_last() {
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        mockPlayerHand.drawCard(new Card("10", "Spades"));
        mockPlayerHand.drawCard(new Card("A", "Hearts"));
        mockPlayerHand.drawCard(new Card("A", "Spades"));
        mockPlayerHand.drawCard(new Card("A", "Clubs"));
        Assertions.assertEquals("Ranking: Three of a kind", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Three of a kind accuracy with a mix of cards")
    @Test
    public void isThreeOfaKindTest_mix() {
        mockPlayerHand.drawCard(new Card("A", "Hearts"));
        mockPlayerHand.drawCard(new Card("J", "Spades"));
        mockPlayerHand.drawCard(new Card("A", "Hearts"));
        mockPlayerHand.drawCard(new Card("10", "Spades"));
        mockPlayerHand.drawCard(new Card("A", "Clubs"));
        Assertions.assertEquals("Ranking: Three of a kind", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Two Pair accuracy with first 4 cards")
    @Test
    public void isTwoPairTest_first() {
        mockPlayerHand.drawCard(new Card("A", "Hearts"));
        mockPlayerHand.drawCard(new Card("A", "Spades"));
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        mockPlayerHand.drawCard(new Card("J", "Spades"));
        mockPlayerHand.drawCard(new Card("10", "Clubs"));
        Assertions.assertEquals("Ranking: Two Pair", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Two Pair accuracy with last 4 cards")
    @Test
    public void isTwoPairTest_last() {
        mockPlayerHand.drawCard(new Card("10", "Hearts"));
        mockPlayerHand.drawCard(new Card("J", "Spades"));
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        mockPlayerHand.drawCard(new Card("A", "Spades"));
        mockPlayerHand.drawCard(new Card("A", "Clubs"));
        Assertions.assertEquals("Ranking: Two Pair", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Two Pair accuracy with a mix of cards")
    @Test
    public void isTwoPairTest_mix() {
        mockPlayerHand.drawCard(new Card("A", "Hearts"));
        mockPlayerHand.drawCard(new Card("J", "Spades"));
        mockPlayerHand.drawCard(new Card("10", "Hearts"));
        mockPlayerHand.drawCard(new Card("A", "Spades"));
        mockPlayerHand.drawCard(new Card("J", "Clubs"));
        Assertions.assertEquals("Ranking: Two Pair", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests One Pair accuracy with first 2 cards")
    @Test
    public void isOnePairTest_first() {
        mockPlayerHand.drawCard(new Card("A", "Hearts"));
        mockPlayerHand.drawCard(new Card("A", "Spades"));
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        mockPlayerHand.drawCard(new Card("9", "Spades"));
        mockPlayerHand.drawCard(new Card("10", "Clubs"));
        Assertions.assertEquals("Ranking: One Pair", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Two Pair accuracy with last 2 cards")
    @Test
    public void isOnePairTest_last() {
        mockPlayerHand.drawCard(new Card("10", "Hearts"));
        mockPlayerHand.drawCard(new Card("9", "Spades"));
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        mockPlayerHand.drawCard(new Card("A", "Spades"));
        mockPlayerHand.drawCard(new Card("A", "Clubs"));
        Assertions.assertEquals("Ranking: One Pair", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests Two Pair accuracy with a mix of cards")
    @Test
    public void isOnePairTest_mix() {
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        mockPlayerHand.drawCard(new Card("A", "Spades"));
        mockPlayerHand.drawCard(new Card("10", "Hearts"));
        mockPlayerHand.drawCard(new Card("A", "Spades"));
        mockPlayerHand.drawCard(new Card("9", "Clubs"));
        Assertions.assertEquals("Ranking: One Pair", mockGame.play(mockPlayerHand));
    }

    @DisplayName("Tests High Card accuracy with a mix of cards")
    @Test
    public void isHighCardTest_mix() {
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        mockPlayerHand.drawCard(new Card("A", "Spades"));
        mockPlayerHand.drawCard(new Card("10", "Hearts"));
        mockPlayerHand.drawCard(new Card("5", "Spades"));
        mockPlayerHand.drawCard(new Card("9", "Clubs"));
        Assertions.assertEquals("Ranking: High Card", mockGame.play(mockPlayerHand));
    }

}

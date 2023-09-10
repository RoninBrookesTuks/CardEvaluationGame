package com.epiusetest.hand;

import com.epiusetest.card.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HandTests {

    private Hand mockPlayerHand;

    @BeforeEach
    public void setup() {
        mockPlayerHand = new Hand(5);
    }

    @DisplayName("Tests viewHand exception handling with incorrect handSize")
    @Test
    public void viewHand_invalidHandSize(){
        mockPlayerHand = new Hand(5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> mockPlayerHand.viewHand());
        assertEquals("viewHand(): Hand size must be at least 1",
                exception.getMessage());
    }

    @DisplayName("Tests accuracy of hand size getter")
    @Test
    public void getHandSizeTest() {
        Assertions.assertEquals(5, mockPlayerHand.getHandSize());
    }

    @DisplayName("Tests the accuracy of the drawCard and viewHand method")
    @Test
    public void drawCardViewHandTest() {
        mockPlayerHand.drawCard(new Card("10", "Hearts"));
        mockPlayerHand.drawCard(new Card("9", "Spades"));
        mockPlayerHand.drawCard(new Card("J", "Hearts"));
        mockPlayerHand.drawCard(new Card("A", "Spades"));
        mockPlayerHand.drawCard(new Card("A", "Clubs"));
        String expectedOutput = "Your hand: 10-Hearts,9-Spades,J-Hearts,A-Spades,A-Clubs";
        Assertions.assertEquals(expectedOutput, mockPlayerHand.viewHand());
    }

}

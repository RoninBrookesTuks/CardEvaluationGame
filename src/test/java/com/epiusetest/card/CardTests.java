package com.epiusetest.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class CardTests {

    @DisplayName("Tests card constructor, getRank() and getSuit()")
    @Test
    public void CardTest() {
        Card card = new Card("2","Hearts");
        Assertions.assertEquals("2", card.rank());
        Assertions.assertEquals("Hearts", card.suit());
    }

    @DisplayName("Tests accurate suit and rank details returned of a card")
    @Test
    public void getDetailsTest() {
        Card card = new Card("7","Diamonds");
        Assertions.assertEquals("7-Diamonds", card.getDetails());
    }

}

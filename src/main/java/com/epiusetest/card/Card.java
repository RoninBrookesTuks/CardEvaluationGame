package com.epiusetest.card;

/**
 * @param suit card suit:
 * @param rank card rank:
 */
public record Card(String rank, String suit) {
    //Return card details:
    public String getDetails() {
        return (rank + "-" + suit);
    }

}

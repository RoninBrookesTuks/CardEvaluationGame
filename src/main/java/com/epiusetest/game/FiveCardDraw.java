package com.epiusetest.game;

import com.epiusetest.card.Card;
import com.epiusetest.deck.StandardDeck;
import com.epiusetest.hand.Hand;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FiveCardDraw extends Game {

    //Variables to hold number of each different rank in the hand
    private  Map<String, Integer> rankCounts;

    //Logger variable to log specific errors details:
    final private Logger logger = Logger.getLogger(Hand.class.getName());

    //Initialize hand and deck:
    public FiveCardDraw() {
        System.out.println("Five-Card Draw Has Been Chosen!");
        playerHand = new Hand(5);
        playerDeck = new StandardDeck();
    }

    //Return card rank-to-integer value:
    public int getRankValue(Card card) {
        return switch (card.rank()) {
            case "A" -> 14;
            case "K" -> 13;
            case "Q" -> 12;
            case "J" -> 11;
            default -> Integer.parseInt(card.rank());
        };
    }

    //Evaluate the hand for each possible ranking:
    @Override
    protected String identifyRank() {
        if(playerHand.getCards().size()!=5){
            String errorMessage = "identifyRank(): Hand size for FiveCardDraw is not 5 cards";
            logger.log(Level.SEVERE, errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        countNumberOfRanks();
        return evaluateHand().toString();
    }

    //Count number of each different rank in the hand
    private void countNumberOfRanks(){
        rankCounts = new HashMap<>();
        for (Card card : playerHand.getCards()) {
            String rank = card.rank();
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
    }

    //Evaluate the players hand by each rule:
    private RankingEnum evaluateHand(){
        if (isStraightFlush()) return RankingEnum.STRAIGHT_FLUSH;
        if (isFourOfAKind()) return RankingEnum.FOUR_OF_A_KIND;
        if (isFullHouse()) return RankingEnum.FULL_HOUSE;
        if (isFlush()) return RankingEnum.FLUSH;
        if (isStraight()) return RankingEnum.STRAIGHT;
        if (isThreeOfAKind()) return RankingEnum.THREE_OF_A_KIND;
        if (isTwoPair()) return RankingEnum.TWO_PAIR;
        if (isOnePair()) return RankingEnum.ONE_PAIR;
        return RankingEnum.HIGH_CARD;
    }

    //Evaluates if ranking is Straight Flush:
    private boolean isStraightFlush() {
        return isFlush() && isStraight();
    }

    //Evaluates if ranking is Four of a kind:
    private boolean isFourOfAKind() {
        return rankCounts.containsValue(4);
    }

    //Evaluates if ranking is Full house:
    private boolean isFullHouse() {
        return rankCounts.containsValue(3) && rankCounts.containsValue(2);
    }

    //Evaluates if ranking is Flush:
    private boolean isFlush() {
        String suit = playerHand.getCards().get(0).suit();
        return playerHand.getCards().stream().allMatch(card -> card.suit().equals(suit));
    }

    //Evaluates if ranking is Straight:
    private boolean isStraight() {
        //Check if ascending or descending:
        if (getRankValue(playerHand.getCards().get(0)) > getRankValue(playerHand.getCards().get(1))) {
            for (int i = 0; i < playerHand.getCards().size() - 1; i++) {
                if (getRankValue(playerHand.getCards().get(i)) != getRankValue(playerHand.getCards().get(i + 1)) + 1) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < playerHand.getCards().size() - 1; i++) {
                if (getRankValue(playerHand.getCards().get(i)) != getRankValue(playerHand.getCards().get(i + 1)) - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    //Evaluate if ranking is Three of a kind:
    private boolean isThreeOfAKind() {
        return rankCounts.containsValue(3);
    }

    //Evaluate if ranking is Two Pair:
    private boolean isTwoPair() {
        int pairCount = 0;
        for (Integer count : rankCounts.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    //Evaluate if ranking is One Pair:
    private boolean isOnePair() {
        return rankCounts.containsValue(2);
    }

}

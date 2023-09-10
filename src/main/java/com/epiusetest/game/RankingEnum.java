package com.epiusetest.game;

//enum class for ranking values
enum RankingEnum {
    STRAIGHT_FLUSH("Ranking: Straight Flush"),
    FOUR_OF_A_KIND("Ranking: Four of a kind"),
    FULL_HOUSE("Ranking: Full House"),
    FLUSH("Ranking: Flush"),
    STRAIGHT("Ranking: Straight"),
    THREE_OF_A_KIND("Ranking: Three of a kind"),
    TWO_PAIR("Ranking: Two Pair"),
    ONE_PAIR("Ranking: One Pair"),
    HIGH_CARD("Ranking: High Card");

    //Accompanying enum description
    private final String description;

    //Sets the enum description
    RankingEnum(String description) {
        this.description = description;
    }

    //Return the description of the enum
    @Override
    public String toString() {
        return description;
    }
}

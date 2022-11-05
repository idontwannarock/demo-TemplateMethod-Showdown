package org.example.showdown.cards;

import org.example.Card;

public class ShowdownCard implements Card<ShowdownCard> {

    private final Rank rank;
    private final Suit suit;

    public ShowdownCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * 比較大小，先比較 Rank 階級，再比較 Suit 花色
     * @return 1 代表本張牌比較大；-1 代表本張牌比較小
     */
    @Override
    public int compare(ShowdownCard other) {
        int rankResult = this.rank.compare(other.rank);
        if (rankResult > 0) {
            return 1;
        } else if (rankResult < 0) {
            return -1;
        } else {
            int suitResult = this.suit.compare(other.suit);
            if (suitResult > 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return rank.rank() + suit.suit();
    }
}

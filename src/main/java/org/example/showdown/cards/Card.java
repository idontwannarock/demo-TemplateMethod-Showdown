package org.example.showdown.cards;

public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int compare(Card other) {
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

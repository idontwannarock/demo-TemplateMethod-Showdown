package org.example.showdown;

import org.example.showdown.cards.Card;
import org.example.showdown.cards.Rank;
import org.example.showdown.cards.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                this.cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public boolean hasCardLeft() {
        return cards.size() > 0;
    }

    public Card drawCard() {
        return cards.remove(0);
    }
}

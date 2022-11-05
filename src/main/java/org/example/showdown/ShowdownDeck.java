package org.example.showdown;

import org.example.showdown.cards.Rank;
import org.example.showdown.cards.ShowdownCard;
import org.example.showdown.cards.Suit;
import org.example.Deck;

public class ShowdownDeck extends Deck<ShowdownCard> {

    public ShowdownDeck() {
        super();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                this.cards.add(new ShowdownCard(rank, suit));
            }
        }
    }
}

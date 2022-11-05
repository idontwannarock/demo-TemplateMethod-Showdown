package org.example.game.showdown;

import org.example.cards.showdown.Rank;
import org.example.cards.showdown.ShowdownCard;
import org.example.cards.showdown.Suit;
import org.example.game.Deck;

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

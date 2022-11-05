package org.example.uno.players;

import org.example.uno.cards.UnoCard;
import org.example.Player;

import java.util.List;

public abstract class UnoPlayer extends Player<UnoCard, UnoHand> {

    public UnoPlayer() {
        super(new UnoHand());
    }

    public abstract void showCard(UnoCard top);

    public int cardCount() {
        return this.hand.cardCount();
    }

    public boolean hasCardLeft() {
        return this.hand.cardCount() > 0;
    }

    protected List<UnoCard> matchCards(UnoCard target) {
        return this.hand.matchCards(target);
    }
}

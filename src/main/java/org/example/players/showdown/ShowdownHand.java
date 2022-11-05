package org.example.players.showdown;

import org.example.cards.showdown.ShowdownCard;
import org.example.players.Hand;

import java.util.List;

public class ShowdownHand extends Hand<ShowdownCard> {

    private ShowdownCard showedCard;

    public ShowdownHand() {
        super();
    }

    public List<ShowdownCard> lookup() {
        return this.cards;
    }

    public void show(ShowdownCard card) {
        this.cards.remove(card);
        this.showedCard = card;
    }

    public ShowdownCard revealCard() {
        ShowdownCard result = this.showedCard;
        this.showedCard = null;
        return result;
    }
}

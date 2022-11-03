package org.example.showdown.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<Card> cards;

    private Card showedCard;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public List<Card> lookup() {
        return this.cards;
    }

    public void show(Card card) {
        this.cards.remove(card);
        this.showedCard = card;
    }

    public Card revealCard() {
        Card result = this.showedCard;
        this.showedCard = null;
        return result;
    }
}

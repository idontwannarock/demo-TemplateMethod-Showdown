package org.example.players;

import org.example.cards.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand<T extends Card<T>> {

    protected final List<T> cards;

    protected T showedCard;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(T card) {
        this.cards.add(card);
    }

    public List<T> lookup() {
        return this.cards;
    }

    public void show(T card) {
        if (card != null) {
            this.cards.remove(card);
        }
        this.showedCard = card;
    }

    public T revealCard() {
        T result = this.showedCard;
        this.showedCard = null;
        return result;
    }
}

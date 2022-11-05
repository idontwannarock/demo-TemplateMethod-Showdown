package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Deck<T extends Card<T>> {

    protected final List<T> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public T drawCard() {
        return cards.remove(0);
    }

    public boolean hasCardLeft() {
        return !cards.isEmpty();
    }

    public boolean isDrained() {
        return cards.isEmpty();
    }
}

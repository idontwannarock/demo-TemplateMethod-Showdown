package org.example.uno;

import org.example.uno.cards.Card;
import org.example.uno.cards.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (int number = 0; number < 10; number++) {
            for (Color color : Color.values()) {
                cards.add(new Card(number, color));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void shuffleBack(Stack<Card> pool) {
        cards.addAll(pool);
        Collections.shuffle(cards);
    }
}

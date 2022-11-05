package org.example.uno;

import org.example.uno.cards.Color;
import org.example.uno.cards.UnoCard;
import org.example.Deck;

import java.util.Stack;

public class UnoDeck extends Deck<UnoCard> {

    public UnoDeck() {
        super();
        for (int number = 0; number < 10; number++) {
            for (Color color : Color.values()) {
                cards.add(new UnoCard(number, color));
            }
        }
    }

    public void shuffleBack(Stack<UnoCard> pool) {
        cards.addAll(pool);
        shuffle();
    }
}

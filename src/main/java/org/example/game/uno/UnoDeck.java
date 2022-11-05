package org.example.game.uno;

import org.example.cards.uno.Color;
import org.example.cards.uno.UnoCard;
import org.example.game.Deck;

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

package org.example.players.uno;

import org.example.cards.uno.Card;

import java.util.List;
import java.util.Random;

public class AiPlayer extends Player {

    @Override
    public void nameHimself() {
        this.name = "AI" + System.currentTimeMillis();
    }

    @Override
    public Card showMatchedCard(Card top) {
        List<Card> matchedCards = this.matchCards(top);
        if (matchedCards.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int chosen = random.nextInt(matchedCards.size());
        return this.hand.choose(matchedCards.get(chosen));
    }
}

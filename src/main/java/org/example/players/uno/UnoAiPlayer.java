package org.example.players.uno;

import org.example.cards.uno.UnoCard;

import java.util.List;
import java.util.Random;

public class UnoAiPlayer extends UnoPlayer {

    @Override
    public void nameHimself() {
        this.name = "AI" + System.currentTimeMillis();
    }

    @Override
    public UnoCard showMatchedCard(UnoCard top) {
        List<UnoCard> matchedCards = this.matchCards(top);
        if (matchedCards.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int chosen = random.nextInt(matchedCards.size());
        return this.hand.choose(matchedCards.get(chosen));
    }
}

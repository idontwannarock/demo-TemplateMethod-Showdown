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
    public void showCard(UnoCard top) {
        List<UnoCard> matchedCards = this.matchCards(top);
        if (matchedCards.isEmpty()) {
            return;
        }
        Random random = new Random();
        int chosen = random.nextInt(matchedCards.size());
        this.hand.show(matchedCards.get(chosen));
    }
}

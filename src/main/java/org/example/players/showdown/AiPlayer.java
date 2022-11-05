package org.example.players.showdown;

import org.example.cards.showdown.Card;

import java.util.List;
import java.util.Random;

public class AiPlayer extends Player {

    @Override
    public void nameHimself() {
        this.name = "AI" + System.currentTimeMillis();
    }

    @Override
    public void showCard() {
        List<Card> hand = this.hand.lookup();
        Random random = new Random();
        int chosen = random.nextInt(hand.size());
        this.hand.show(hand.get(chosen));
    }
}

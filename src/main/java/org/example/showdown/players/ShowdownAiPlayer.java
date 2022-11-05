package org.example.showdown.players;

import org.example.showdown.cards.ShowdownCard;

import java.util.List;
import java.util.Random;

public class ShowdownAiPlayer extends ShowdownPlayer {

    @Override
    public void nameHimself() {
        this.name = "AI" + System.currentTimeMillis();
    }

    @Override
    public void showCard() {
        List<ShowdownCard> hand = this.hand.lookup();
        Random random = new Random();
        int chosen = random.nextInt(hand.size());
        this.hand.show(hand.get(chosen));
    }
}

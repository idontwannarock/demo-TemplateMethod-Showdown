package org.example.game.uno;

import org.example.cards.uno.UnoCard;
import org.example.game.Game;
import org.example.players.uno.UnoAiPlayer;
import org.example.players.uno.UnoHand;
import org.example.players.uno.UnoPlayer;

import java.util.*;
import java.util.stream.IntStream;

public class UnoGame extends Game<UnoCard, UnoHand, UnoPlayer, UnoDeck> {

    private Stack<UnoCard> pool;

    public UnoGame() {
        super(new UnoDeck(), 4);
        this.pool = new Stack<>();
    }

    @Override
    protected void setUpPlayers() {
        if (this.players.size() < 4) {
            IntStream.range(0, 4 - this.players.size())
                    .forEach(number -> addOneAiPlayer());
        }
        Collections.shuffle(this.players);
    }

    private void addOneAiPlayer() {
        this.players.add(new UnoAiPlayer());
    }

    @Override
    protected void drawCards() {
        IntStream.range(0, 5).forEach(i -> players.forEach(player -> player.drawCard(deck)));
    }

    @Override
    protected void play() {
        this.pool.push(this.deck.drawCard());
        while (this.players.stream().allMatch(UnoPlayer::hasCardLeft)) {
            UnoPlayer current = players.remove(0);
            UnoCard top = pool.peek();

            UnoCard chosen = current.showMatchedCard(top);

            if (chosen == null) {
                current.drawCard(deck);
            } else {
                pool.push(chosen);
            }

            if (deck.isDrain()) {
                pool.pop();
                deck.shuffleBack(pool);
                pool = new Stack<>();
                pool.push(top);
            }

            this.players.add(3, current);
        }
    }

    @Override
    protected void settleGame() {
        this.players.stream()
                .min(Comparator.comparingInt(UnoPlayer::cardCount))
                .ifPresent(player -> System.out.println("Game winner is " + player.getName()));
    }
}

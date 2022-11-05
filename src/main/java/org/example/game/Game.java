package org.example.game;

import org.example.cards.Card;
import org.example.players.Hand;
import org.example.players.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Game<C extends Card<C>, H extends Hand<C>, P extends Player<C, H>, D extends Deck<C>> {

    protected final List<P> players;

    protected final D deck;

    private final int playerSize;

    public Game(D deck, int playerSize) {
        this.players = new ArrayList<>();
        this.deck = deck;
        this.playerSize = playerSize;
    }

    public Game<C, H, P, D> join(P player) {
        if (this.players.size() == playerSize) {
            throw new IllegalArgumentException("Too many players!");
        }
        this.players.add(player);
        return this;
    }

    public void start() {
        setUpPlayers();
        namePlayers();
        shuffleDeck();
        drawCards();
        play();
        settleGame();
    }

    protected abstract void setUpPlayers();

    protected abstract void drawCards();

    protected abstract void play();

    protected abstract void settleGame();

    private void namePlayers() {
        this.players.forEach(Player::nameHimself);
        System.out.println();
        System.out.println("Players in order:");
        for (int player = 0; player < players.size(); player++) {
            System.out.println("P" + (player + 1) + ": " + this.players.get(player).getName());
        }
        System.out.println();
    }

    private void shuffleDeck() {
        this.deck.shuffle();
    }
}

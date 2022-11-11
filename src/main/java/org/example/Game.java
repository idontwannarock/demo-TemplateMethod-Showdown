package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Game<C extends Card<C>, H extends Hand<C>, P extends Player<C, H>, D extends Deck<C>> {

    protected final List<P> players;

    protected final D deck;

    protected final int playerSize;

    protected P winner;

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
        findGameWinner();
        printGameWinnerName();
    }

    protected void setUpPlayers() {
        if (notEnoughPlayers()) {
            addAiPlayers();
        }
        shufflePlayerOrder();
    }

    protected boolean notEnoughPlayers() {
        return this.players.size() < this.playerSize;
    }

    protected void addAiPlayers() {
        for (int playerCount = 0; playerCount < this.playerSize - this.players.size(); playerCount++) {
            addOneAiPlayer();
        }
    }

    protected abstract void addOneAiPlayer();

    protected void shufflePlayerOrder() {
        Collections.shuffle(this.players);
    }

    protected void drawCards() {
        while (isNotReachDrawCardLimit()) {
            eachPlayerDrawsOneCard();
        }
    }

    protected abstract boolean isNotReachDrawCardLimit();

    protected void eachPlayerDrawsOneCard() {
        this.players.forEach(player -> player.drawCard(this.deck));
    }

    protected void play() {
        prepareBeforeFirstRound();
        while (isGameNotFinished()) {
            playOneRound();
        }
    }

    protected abstract void prepareBeforeFirstRound();

    protected abstract boolean isGameNotFinished();

    protected abstract void playOneRound();

    protected abstract void findGameWinner();

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

    private void printGameWinnerName() {
        System.out.println("Game winner is " + winner.getName() + "!");
    }
}

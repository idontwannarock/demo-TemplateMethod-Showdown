package org.example.showdown;

import org.example.showdown.players.AiPlayer;
import org.example.showdown.players.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

    private final List<Player> players;

    private final Deck deck;

    private final int rounds;

    public Game() {
        this.players = new ArrayList<>();
        this.deck = new Deck();
        this.rounds = 13;
    }

    public Game join(Player player) {
        if (this.players.size() == 4) {
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

    private void setUpPlayers() {
        if (this.players.size() < 4) {
            IntStream.range(0, 4 - this.players.size())
                    .forEach(number -> addOneAiPlayer());
        }
        Collections.shuffle(this.players);
    }

    private void addOneAiPlayer() {
        this.players.add(new AiPlayer());
    }

    private void namePlayers() {
        this.players.forEach(Player::nameHimself);
        System.out.println();
        System.out.println("Players in order:");
        System.out.println("P1: " + this.players.get(0).getName());
        System.out.println("P2: " + this.players.get(1).getName());
        System.out.println("P3: " + this.players.get(2).getName());
        System.out.println("P3: " + this.players.get(3).getName());
        System.out.println();
    }

    private void shuffleDeck() {
        this.deck.shuffle();
    }

    private void drawCards() {
        while (this.deck.hasCardLeft()) {
            this.players.forEach(player -> player.drawCard(this.deck));
        }
    }

    private void play() {
        for (int round = 0; round < this.rounds; round++) {
            this.players.forEach(Player::showCard);
            this.players.stream()
                    .collect(Collectors.toMap(Player::revealCard, player -> player))
                    .entrySet()
                    .stream()
                    .reduce((entry1, entry2) -> entry1.getKey().compare(entry2.getKey()) > 0 ? entry1 : entry2)
                    .ifPresent(entry -> {
                        entry.getValue().addPoint();
                        System.out.println("Winner of this round is " + entry.getValue().getName());
                        System.out.println();
                    });
        }
    }

    private void settleGame() {
        this.players.stream()
                .reduce((player1, player2) -> player1.getPoints() - player2.getPoints() > 0 ? player1 : player2)
                .ifPresent(player -> System.out.println("Game winner is " + player.getName() + "!"));
    }
}

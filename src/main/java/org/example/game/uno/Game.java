package org.example.game.uno;

import org.example.cards.uno.Card;
import org.example.players.uno.AiPlayer;
import org.example.players.uno.Player;

import java.util.*;
import java.util.stream.IntStream;

public class Game {

    private final List<Player> players;

    private final Deck deck;

    private Stack<Card> pool;

    public Game() {
        this.players = new LinkedList<>();
        this.deck = new Deck();
        this.pool = new Stack<>();
    }

    public Game join(Player player) {
        if (players.size() == 4) {
            throw new IllegalArgumentException("Too many players!");
        }
        players.add(player);
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
        IntStream.range(0, 5).forEach(i -> players.forEach(player -> player.drawCard(deck)));
    }

    private void play() {
        this.pool.push(this.deck.drawCard());
        while (this.players.stream().allMatch(Player::hasCardLeft)) {
            Player current = players.remove(0);
            Card top = pool.peek();

            Card chosen = current.showMatchedCard(top);

            if (chosen == null) {
                current.drawCard(deck);
            } else {
                pool.push(chosen);
            }

            if (deck.isEmpty()) {
                pool.pop();
                deck.shuffleBack(pool);
                pool = new Stack<>();
                pool.push(top);
            }

            this.players.add(3, current);
        }
    }

    private void settleGame() {
        this.players.stream()
                .min(Comparator.comparingInt(Player::cardCount))
                .ifPresent(player -> System.out.println("Game winner is " + player.getName()));
    }
}

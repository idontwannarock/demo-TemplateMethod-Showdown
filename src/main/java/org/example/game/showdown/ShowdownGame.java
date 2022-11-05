package org.example.game.showdown;

import org.example.cards.showdown.ShowdownCard;
import org.example.game.Game;
import org.example.players.showdown.ShowdownAiPlayer;
import org.example.players.showdown.ShowdownHand;
import org.example.players.showdown.ShowdownPlayer;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShowdownGame extends Game<ShowdownCard, ShowdownHand, ShowdownPlayer, ShowdownDeck> {

    private final int rounds;

    public ShowdownGame() {
        super(new ShowdownDeck(), 4);
        this.rounds = 13;
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
        this.players.add(new ShowdownAiPlayer());
    }

    @Override
    protected void drawCards() {
        while (this.deck.hasCardLeft()) {
            this.players.forEach(player -> player.drawCard(this.deck));
        }
    }

    @Override
    protected void play() {
        for (int round = 0; round < this.rounds; round++) {
            this.players.forEach(ShowdownPlayer::showCard);
            this.players.stream()
                    .collect(Collectors.toMap(ShowdownPlayer::revealCard, player -> player))
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

    @Override
    protected void settleGame() {
        this.players.stream()
                .reduce((player1, player2) -> player1.getPoints() - player2.getPoints() > 0 ? player1 : player2)
                .ifPresent(player -> System.out.println("Game winner is " + player.getName() + "!"));
    }
}

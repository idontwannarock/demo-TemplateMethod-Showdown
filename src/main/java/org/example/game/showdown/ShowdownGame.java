package org.example.game.showdown;

import org.example.cards.showdown.ShowdownCard;
import org.example.game.Game;
import org.example.players.showdown.ShowdownAiPlayer;
import org.example.players.showdown.ShowdownHand;
import org.example.players.showdown.ShowdownPlayer;

import java.util.Map;
import java.util.stream.Collectors;

public class ShowdownGame extends Game<ShowdownCard, ShowdownHand, ShowdownPlayer, ShowdownDeck> {

    private final static int TOTAL_ROUNDS = 13;

    public ShowdownGame() {
        super(new ShowdownDeck(), 4);
    }

    @Override
    protected void addOneAiPlayer() {
        this.players.add(new ShowdownAiPlayer());
    }

    @Override
    protected void drawCards() {
        while (deckIsNotDrained()) {
            eachPlayerDrawsOneCard();
        }
    }

    @Override
    protected void play() {
        for (int round = 0; round < TOTAL_ROUNDS; round++) {
            eachPlayersShowsOneCard();
            Map<ShowdownCard, ShowdownPlayer> revealedCards = revealAllShowedCards();
            ShowdownPlayer winner = findWinner(revealedCards);
            winnerAddOnePoint(winner);
        }
    }

    @Override
    protected void findGameWinner() {
        this.winner = this.players.stream()
                .reduce((player1, player2) -> player1.getPoints() - player2.getPoints() > 0 ? player1 : player2)
                .orElseThrow();
    }

    private boolean deckIsNotDrained() {
        return this.deck.hasCardLeft();
    }

    private void eachPlayersShowsOneCard() {
        this.players.forEach(ShowdownPlayer::showCard);
    }

    private Map<ShowdownCard, ShowdownPlayer> revealAllShowedCards() {
        return this.players.stream()
                .collect(Collectors.toMap(ShowdownPlayer::revealCard, player -> player));
    }

    private ShowdownPlayer findWinner(Map<ShowdownCard, ShowdownPlayer> revealedCards) {
        return revealedCards
                .entrySet()
                .stream()
                .reduce((entry1, entry2) -> entry1.getKey().compare(entry2.getKey()) > 0 ? entry1 : entry2)
                .map(Map.Entry::getValue)
                .orElseThrow();
    }

    private void winnerAddOnePoint(ShowdownPlayer winner) {
        winner.addPoint();
        System.out.println("Winner of this round is " + winner.getName());
        System.out.println();
    }
}

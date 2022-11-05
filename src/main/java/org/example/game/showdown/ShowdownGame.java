package org.example.game.showdown;

import org.example.cards.showdown.ShowdownCard;
import org.example.game.Game;
import org.example.players.showdown.ShowdownAiPlayer;
import org.example.players.showdown.ShowdownHand;
import org.example.players.showdown.ShowdownPlayer;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class ShowdownGame extends Game<ShowdownCard, ShowdownHand, ShowdownPlayer, ShowdownDeck> {

    private final int rounds;

    public ShowdownGame() {
        super(new ShowdownDeck(), 4);
        this.rounds = 13;
    }

    @Override
    protected void setUpPlayers() {
        if (notEnoughPlayers()) {
            addAiPlayers();
        }
        shufflePlayerOrder();
    }

    @Override
    protected void drawCards() {
        while (deckIsNotDrained()) {
            eachPlayersDrawsOneCard();
        }
    }

    @Override
    protected void play() {
        for (int round = 0; round < this.rounds; round++) {
            eachPlayersShowsOneCard();
            Map<ShowdownCard, ShowdownPlayer> revealedCards = revealAllShowedCards();
            ShowdownPlayer winner = findWinner(revealedCards);
            winnerAddOnePoint(winner);
        }
    }

    @Override
    protected void settleGame() {
        ShowdownPlayer winner = findGameWinner();
        printGameWinnerName(winner);
    }

    private boolean notEnoughPlayers() {
        return this.players.size() < this.playerSize;
    }

    private void addAiPlayers() {
        for (int playerCount = 0; playerCount < this.playerSize - this.players.size(); playerCount++) {
            addOneAiPlayer();
        }
    }

    private void addOneAiPlayer() {
        this.players.add(new ShowdownAiPlayer());
    }

    private void shufflePlayerOrder() {
        Collections.shuffle(this.players);
    }

    private boolean deckIsNotDrained() {
        return this.deck.hasCardLeft();
    }

    private void eachPlayersDrawsOneCard() {
        this.players.forEach(player -> player.drawCard(this.deck));
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

    private ShowdownPlayer findGameWinner() {
        return this.players.stream()
                .reduce((player1, player2) -> player1.getPoints() - player2.getPoints() > 0 ? player1 : player2)
                .orElseThrow();
    }

    private void printGameWinnerName(ShowdownPlayer winner) {
        System.out.println("Game winner is " + winner.getName() + "!");
    }
}

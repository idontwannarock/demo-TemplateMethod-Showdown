package org.example.uno;

import org.example.uno.cards.UnoCard;
import org.example.Game;
import org.example.uno.players.UnoAiPlayer;
import org.example.uno.players.UnoHand;
import org.example.uno.players.UnoPlayer;

import java.util.Comparator;
import java.util.Stack;

public class UnoGame extends Game<UnoCard, UnoHand, UnoPlayer, UnoDeck> {

    private final static int PLAYER_INITIAL_CARDS_COUNT = 5;
    private Stack<UnoCard> pool;

    public UnoGame() {
        super(new UnoDeck(), 4);
        this.pool = new Stack<>();
    }

    @Override
    protected void addOneAiPlayer() {
        this.players.add(new UnoAiPlayer());
    }

    @Override
    protected boolean isNotReachDrawCardLimit() {
        return this.players.get(0).cardCount() < PLAYER_INITIAL_CARDS_COUNT;
    }

    @Override
    protected void prepareBeforeFirstRound() {
        this.pool.push(this.deck.drawCard());
    }

    @Override
    protected boolean isGameNotFinished() {
        return this.players.stream().allMatch(UnoPlayer::hasCardLeft);
    }

    @Override
    protected void playOneRound() {
        UnoPlayer currentPlayer = getCurrentPlayer();
        UnoCard currentTopCard = getTopCard();

        UnoCard chosenCard = choose(currentPlayer, currentTopCard);

        if (playerChoseNotToPlayCard(chosenCard)) {
            playerDrawsOneCard(currentPlayer);
        } else {
            putCardOnPoolTop(chosenCard);
        }

        if (deckIsDrained()) {
            shufflePollBackToDeck();
            putCardOnPoolTop(currentTopCard);
        }
    }

    @Override
    protected void findGameWinner() {
        this.winner = this.players.stream()
                .min(Comparator.comparingInt(UnoPlayer::cardCount)).orElseThrow();
    }

    private UnoPlayer getCurrentPlayer() {
        UnoPlayer current = players.remove(0);
        this.players.add(3, current);
        return current;
    }

    private UnoCard getTopCard() {
        return pool.pop();
    }

    private UnoCard choose(UnoPlayer current, UnoCard top) {
        current.showCard(top);
        return current.revealCard();
    }

    private boolean playerChoseNotToPlayCard(UnoCard chosen) {
        return chosen == null;
    }

    private void playerDrawsOneCard(UnoPlayer current) {
        current.drawCard(deck);
    }

    private void putCardOnPoolTop(UnoCard chosen) {
        pool.push(chosen);
    }

    private boolean deckIsDrained() {
        return deck.isDrained();
    }

    private void shufflePollBackToDeck() {
        deck.shuffleBack(pool);
        pool = new Stack<>();
    }
}

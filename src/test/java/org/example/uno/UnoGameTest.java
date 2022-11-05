package org.example.uno;

import org.example.Game;
import org.example.uno.cards.UnoCard;
import org.example.uno.players.UnoAiPlayer;
import org.example.uno.players.UnoHand;
import org.example.uno.players.UnoHumanPlayer;
import org.example.uno.players.UnoPlayer;
import org.junit.Test;

public class UnoGameTest {

    @Test(expected = IllegalArgumentException.class)
    public void givenFourPlayers_whenAddingAnotherPlayer_throwIllegalArgumentException() {
        // arrange
        Game<UnoCard, UnoHand, UnoPlayer, UnoDeck> game = new UnoGame()
                .join(new UnoHumanPlayer())
                .join(new UnoAiPlayer())
                .join(new UnoHumanPlayer())
                .join(new UnoAiPlayer());

        // act
        game.join(new UnoHumanPlayer());
    }
}

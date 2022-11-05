package org.example.showdown;

import org.example.Game;
import org.example.showdown.cards.ShowdownCard;
import org.example.showdown.players.ShowdownAiPlayer;
import org.example.showdown.players.ShowdownHand;
import org.example.showdown.players.ShowdownHumanPlayer;
import org.example.showdown.players.ShowdownPlayer;
import org.junit.Test;

public class ShowdownGameTest {

    @Test(expected = IllegalArgumentException.class)
    public void givenFourPlayers_whenAddingAnotherPlayer_throwIllegalArgumentException() {
        // arrange
        Game<ShowdownCard, ShowdownHand, ShowdownPlayer, ShowdownDeck> game = new ShowdownGame()
                .join(new ShowdownHumanPlayer())
                .join(new ShowdownAiPlayer())
                .join(new ShowdownHumanPlayer())
                .join(new ShowdownAiPlayer());

        // act
        game.join(new ShowdownHumanPlayer());
    }
}

package org.example;

import org.example.game.showdown.ShowdownGame;
import org.example.game.uno.UnoGame;
import org.example.players.showdown.ShowdownHumanPlayer;
import org.example.players.uno.UnoHumanPlayer;

public class App {

    public static void main(String[] args) {
        // showdown
        new ShowdownGame()
                .join(new ShowdownHumanPlayer())
                .start();

        // uno
        new UnoGame()
                .join(new UnoHumanPlayer())
                .start();
    }
}

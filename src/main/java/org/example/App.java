package org.example;

import org.example.game.showdown.Game;
import org.example.players.showdown.CommandLineInterface;
import org.example.players.showdown.HumanPlayer;

public class App {

    public static void main(String[] args) {
        // showdown
        new Game()
                .join(new HumanPlayer(new CommandLineInterface()))
                .start();

        // uno
        new org.example.game.uno.Game()
                .join(new org.example.players.uno.HumanPlayer(new org.example.players.uno.CommandLineInterface()))
                .start();
    }
}

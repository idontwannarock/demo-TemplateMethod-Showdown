package org.example;

import org.example.showdown.cards.Game;
import org.example.showdown.players.CommandLineInterface;
import org.example.showdown.players.HumanPlayer;

public class App {

    public static void main(String[] args) {
        // showdown
        new Game()
                .join(new HumanPlayer(new CommandLineInterface()))
                .play();
    }
}

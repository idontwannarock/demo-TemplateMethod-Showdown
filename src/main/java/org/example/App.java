package org.example;

import org.example.showdown.Game;
import org.example.showdown.players.CommandLineInterface;
import org.example.showdown.players.HumanPlayer;

public class App {

    public static void main(String[] args) {
        // showdown
//        new Game()
//                .join(new HumanPlayer(new CommandLineInterface()))
//                .start();

        // uno
        new org.example.uno.Game()
                .join(new org.example.uno.players.HumanPlayer(new org.example.uno.players.CommandLineInterface()))
                .start();
    }
}

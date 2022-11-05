package org.example.players.showdown;

import org.example.cards.showdown.ShowdownCard;
import org.example.players.CommandLineInterface;

public class ShowdownHumanPlayer extends ShowdownPlayer {

    private final CommandLineInterface<ShowdownCard> commandLineInterface;

    public ShowdownHumanPlayer() {
        this.commandLineInterface = new CommandLineInterface<>();
    }

    @Override
    public void nameHimself() {
        this.name = commandLineInterface.enterName();
    }

    @Override
    public void showCard() {
        this.hand.show(commandLineInterface.choose(this.hand.lookup()));
    }
}

package org.example.showdown.players;

import org.example.showdown.cards.ShowdownCard;
import org.example.CommandLineInterface;

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
        ShowdownCard chosen;
        do {
            chosen = commandLineInterface.choose(this.hand.lookup());
        } while (chosen == null);
        this.hand.show(chosen);
    }
}

package org.example.players.uno;

import org.example.cards.uno.UnoCard;
import org.example.players.CommandLineInterface;

public class UnoHumanPlayer extends UnoPlayer {

    private final CommandLineInterface<UnoCard> commandLineInterface;

    public UnoHumanPlayer() {
        this.commandLineInterface = new CommandLineInterface<>();
    }

    @Override
    public void nameHimself() {
        this.name = commandLineInterface.enterName();
    }

    @Override
    public void showCard(UnoCard top) {
        UnoCard chosen;
        do {
            chosen = commandLineInterface.choose(this.hand.lookup());
        } while (hasChosenCard(chosen) && isChosenCardNotMatchedTopCard(chosen, top));
        this.hand.show(chosen);
    }

    private boolean hasChosenCard(UnoCard chosen) {
        return chosen != null;
    }

    private boolean isChosenCardNotMatchedTopCard(UnoCard chosen, UnoCard top) {
        return chosen.compare(top) < 0;
    }
}

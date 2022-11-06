package org.example.showdown.players;

import org.example.PlayerInterface;
import org.example.interfaces.CommandLineInterface;
import org.example.showdown.cards.ShowdownCard;

public class ShowdownHumanPlayer extends ShowdownPlayer {

    private final PlayerInterface<ShowdownCard> playerInterface;

    public ShowdownHumanPlayer() {
        this.playerInterface = new CommandLineInterface<>();
    }

    public ShowdownHumanPlayer(PlayerInterface<ShowdownCard> playerInterface) {
        this.playerInterface = playerInterface;
    }

    @Override
    public void nameHimself() {
        this.name = playerInterface.enterName();
    }

    @Override
    public void showCard() {
        ShowdownCard chosen;
        do {
            chosen = playerInterface.choose(this.hand.lookup());
        } while (chosen == null);
        this.hand.show(chosen);
    }
}

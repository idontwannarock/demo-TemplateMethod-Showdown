package org.example.uno.players;

import org.example.PlayerInterface;
import org.example.interfaces.CommandLineInterface;
import org.example.uno.cards.UnoCard;

public class UnoHumanPlayer extends UnoPlayer {

    private final PlayerInterface<UnoCard> playerInterface;

    public UnoHumanPlayer() {
        this.playerInterface = new CommandLineInterface<>();
    }

    public UnoHumanPlayer(PlayerInterface<UnoCard> playerInterface) {
        this.playerInterface = playerInterface;
    }

    @Override
    public void nameHimself() {
        this.name = playerInterface.enterName();
    }

    @Override
    public void showCard(UnoCard top) {
        UnoCard chosen;
        do {
            chosen = playerInterface.choose(this.hand.lookup());
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

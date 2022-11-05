package org.example.players.uno;

import org.example.cards.uno.UnoCard;
import org.example.players.CommandLineInterface;

import java.util.List;

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
    public UnoCard showMatchedCard(UnoCard top) {
        System.out.println("The card on the top of the pool is " + top.toString());
        List<UnoCard> matchedCards = this.matchCards(top);
        if (matchedCards.isEmpty()) {
            System.out.println("You have no matched card in hand.");
            return null;
        }
        UnoCard chosen = commandLineInterface.choose(matchedCards);
        return this.hand.choose(chosen);
    }
}

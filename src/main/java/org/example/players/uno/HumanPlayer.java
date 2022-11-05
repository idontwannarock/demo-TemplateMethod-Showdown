package org.example.players.uno;

import org.example.cards.uno.Card;

import java.util.List;

public class HumanPlayer extends Player {

    private final CommandLineInterface commandLineInterface;

    public HumanPlayer(CommandLineInterface commandLineInterface) {
        this.commandLineInterface = commandLineInterface;
    }

    @Override
    public void nameHimself() {
        this.name = commandLineInterface.enterName();
    }

    @Override
    public Card showMatchedCard(Card top) {
        System.out.println("The card on the top of the pool is " + top.toString());
        List<Card> matchedCards = this.matchCards(top);
        if (matchedCards.isEmpty()) {
            System.out.println("You have no matched card in hand.");
            return null;
        }
        Card chosen = commandLineInterface.choose(matchedCards);
        return this.hand.choose(chosen);
    }
}

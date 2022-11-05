package org.example.players;

import org.example.cards.Card;
import org.example.game.Deck;

public abstract class Player<C extends Card<C>, H extends Hand<C>> {

    protected String name;
    protected H hand;

    public Player(H hand) {
        this.hand = hand;
    }

    public abstract void nameHimself();

    public String getName() {
        return this.name;
    }

    public void drawCard(Deck<C> deck) {
        this.hand.addCard(deck.drawCard());
    }

    public C revealCard() {
        C revealedCard = this.hand.revealCard();
        System.out.println("Player " + getName() + " has played " + revealedCard.toString());
        return revealedCard;
    }
}

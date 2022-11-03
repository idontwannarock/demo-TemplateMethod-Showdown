package org.example.showdown.players;

import org.example.showdown.Hand;
import org.example.showdown.cards.Card;
import org.example.showdown.Deck;

public abstract class Player {

    protected String name;
    protected Hand hand;
    private int points;

    public abstract void nameHimself();

    public abstract void showCard();

    public String getName() {
        return this.name;
    }

    public void drawCard(Deck deck) {
        if (this.hand == null) {
            this.hand = new Hand();
        }
        this.hand.addCard(deck.drawCard());
    }

    public Card revealCard() {
        Card revealedCard = hand.revealCard();
        System.out.println("Player " + getName() + " played " + revealedCard.toString());
        return revealedCard;
    }

    public void addPoint() {
        this.points++;
    }

    public int getPoints() {
        return points;
    }
}

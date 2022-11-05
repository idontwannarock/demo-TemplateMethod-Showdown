package org.example.players.showdown;

import org.example.cards.showdown.ShowdownCard;
import org.example.game.showdown.ShowdownDeck;
import org.example.players.Player;

public abstract class ShowdownPlayer extends Player<ShowdownCard, ShowdownHand> {

    private int points;

    public ShowdownPlayer() {
        super(new ShowdownHand());
    }

    public abstract void showCard();

    public ShowdownCard revealCard() {
        ShowdownCard revealedCard = hand.revealCard();
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

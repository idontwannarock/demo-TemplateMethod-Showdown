package org.example.showdown.players;

import org.example.showdown.cards.ShowdownCard;
import org.example.Player;

public abstract class ShowdownPlayer extends Player<ShowdownCard, ShowdownHand> {

    private int points;

    public ShowdownPlayer() {
        super(new ShowdownHand());
    }

    public abstract void showCard();

    public void addPoint() {
        this.points++;
    }

    public int getPoints() {
        return points;
    }
}

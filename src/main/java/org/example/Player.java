package org.example;

public abstract class Player {

    protected String name;
    protected Hand hand;
    private int points;

    public abstract void nameHimself();

    public abstract void showCard();

    public void drawCard(Deck deck) {
    }

    public Card revealCard() {
    }

    public void addPoint() {
    }

    public String getName() {
    }

    public int getPoints() {
    }
}

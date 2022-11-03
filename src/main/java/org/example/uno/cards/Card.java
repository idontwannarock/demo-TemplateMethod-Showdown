package org.example.uno.cards;

public class Card {

    private final int number;
    private final Color color;

    public Card(int number, Color color) {
        this.number = number;
        this.color = color;
    }

    public boolean isNumberOrColorEqual(Card other) {
        return number == other.number || color == other.color;
    }

    @Override
    public String toString() {
        return number + color.name();
    }
}

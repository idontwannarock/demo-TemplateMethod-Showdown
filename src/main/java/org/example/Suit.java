package org.example;

public enum Suit {
    CLUB(1, "♣"),
    DIAMOND(2, "♦"),
    HEART(3, "♥"),
    SPADE(4, "♠");

    private final int number;
    private final String suit;

    Suit(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    public int compare(Suit other) {
        return this.number - other.number;
    }

    public String suit() {
        return this.suit;
    }
}

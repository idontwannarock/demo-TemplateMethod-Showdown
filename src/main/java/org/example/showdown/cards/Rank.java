package org.example.showdown.cards;

public enum Rank {
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K"),
    ACE(14, "A");

    private final int number;
    private final String rank;

    Rank(int number, String name) {
        this.number = number;
        this.rank = name;
    }

    public int compare(Rank other) {
        return this.number - other.number;
    }

    public String rank() {
        return this.rank;
    }
}

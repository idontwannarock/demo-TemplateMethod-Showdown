package org.example.uno.cards;

import org.example.Card;

public class UnoCard implements Card<UnoCard> {

    private final int number;
    private final Color color;

    public UnoCard(int number, Color color) {
        this.number = number;
        this.color = color;
    }

    /**
     * 比較兩張牌是否同 Number 數字或 Color 顏色
     * @return 1 代表數字或花色相同；-1 代表兩者皆不同
     */
    @Override
    public int compare(UnoCard other) {
        return number == other.number || color == other.color
                ? 1
                : -1;
    }

    @Override
    public String toString() {
        return number + color.name();
    }
}

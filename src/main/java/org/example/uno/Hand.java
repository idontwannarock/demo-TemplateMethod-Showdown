package org.example.uno;

import org.example.uno.cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {

    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public int cardCount() {
        return this.cards.size();
    }

    public List<Card> matchCards(Card target) {
        return this.cards.stream().filter(card -> card.isNumberOrColorEqual(target)).collect(Collectors.toList());
    }

    public Card choose(Card card) {
        this.cards.remove(card);
        return card;
    }
}

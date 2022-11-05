package org.example.players.uno;

import org.example.cards.uno.UnoCard;
import org.example.players.Hand;

import java.util.List;
import java.util.stream.Collectors;

public class UnoHand extends Hand<UnoCard> {

    public UnoHand() {
       super();
    }

    public int cardCount() {
        return this.cards.size();
    }

    public List<UnoCard> matchCards(UnoCard target) {
        return this.cards.stream()
                .filter(card -> card.compare(target) == 1)
                .collect(Collectors.toList());
    }

    public UnoCard choose(UnoCard card) {
        this.cards.remove(card);
        return card;
    }
}

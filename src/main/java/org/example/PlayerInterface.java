package org.example;

import java.util.List;

public interface PlayerInterface<T extends Card<T>> {

    String enterName();

    /**
     * List all cards with options starting from 0, and -1 options means not choosing.
     *
     * @return the Card the player has chosen or null if the player has chosen nothing.
     */
    T choose(List<T> cards);
}

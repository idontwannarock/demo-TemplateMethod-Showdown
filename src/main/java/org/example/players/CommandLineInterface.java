package org.example.players;

import org.example.cards.Card;

import java.util.List;
import java.util.Scanner;

public class CommandLineInterface<T extends Card<T>> {

    private final Scanner scanner = new Scanner(System.in);

    public String enterName() {
        System.out.println("Please enter your name and press enter:");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");
        return name;
    }

    /**
     * List all cards with options starting from 0, and -1 options means not choosing.
     * @return the Card the player chose or null if the player chose nothing.
     */
    public T choose(List<T> cards) {
        T chosen = null;
        while (chosen == null) {
            try {
                printCards(cards);
                int pick = scanner.nextInt();
                if (pick == -1) {
                    break;
                }
                chosen = cards.get(pick);
            } catch (Exception ignored) {
                System.out.println("You have picked a wrong option. Please choose again.");
            }
        }
        System.out.println("You choose " + chosen + ".");
        System.out.println();
        return chosen;
    }

    private void printCards(List<T> cards) {
        if (cards.isEmpty()) return;

        System.out.println("Here are your cards at hand:");
        System.out.println("-1: not choosing");
        for (int index = 0; index < cards.size(); index++) {
            System.out.println(index + ": " + cards.get(index).toString());
        }
        System.out.println("Please enter an option (-1 - " + (cards.size() - 1) + ") of a card and press enter:");
    }
}

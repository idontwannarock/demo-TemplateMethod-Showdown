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

    public T choose(List<T> cards) {
        printCards(cards);
        T card = cards.get(scanner.nextInt());
        System.out.println("You choose " + card.toString() + ".");
        System.out.println();
        return card;
    }

    private void printCards(List<T> cards) {
        System.out.println("Here are your cards at hand:");
        for (int index = 0; index < cards.size(); index++) {
            System.out.println(index + ": " + cards.get(index).toString());
        }
        System.out.println("Please choose a card and press enter:");
    }
}

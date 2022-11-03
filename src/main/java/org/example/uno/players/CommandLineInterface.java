package org.example.uno.players;

import org.example.uno.cards.Card;

import java.util.List;
import java.util.Scanner;

public class CommandLineInterface {

    private final Scanner scanner = new Scanner(System.in);

    public String enterName() {
        System.out.println("Please enter your name and press enter:");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");
        return name;
    }

    public Card choose(List<Card> cards) {
        printCards(cards);
        Card card = cards.get(scanner.nextInt());
        System.out.println("You choose " + card.toString() + ".");
        System.out.println();
        return card;
    }

    private void printCards(List<Card> cards) {
        System.out.println("Here are your matched cards at hand:");
        for (int index = 0; index < cards.size(); index++) {
            System.out.println(index + ": " + cards.get(index).toString());
        }
        System.out.println("Please choose a card and press enter:");
    }
}

package org.example.interfaces;

import org.example.Card;
import org.example.PlayerInterface;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandLineInterface<T extends Card<T>> implements PlayerInterface<T> {

    @Override
    public String enterName() {
        String name = null;
        Scanner scanner = new Scanner(System.in);
        while (name == null) {
            try {
                System.out.println("Please enter your name and press enter:");
                name = scanner.nextLine();
                if (name != null && !name.isBlank()) {
                    System.out.println("Hello " + name + "!");
                } else {
                    System.out.print("Your must provide a name. ");
                    name = null;
                }
            } catch (NoSuchElementException ignore) {
                System.out.print("Your must provide a name. ");
            }
        }
        return name;
    }

    @Override
    public T choose(List<T> cards) {
        if (cards == null || cards.isEmpty()) {
            System.out.println("You have no cards to choose from.");
            return null;
        }
        T chosen = null;
        Scanner scanner = new Scanner(System.in);
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
        if (chosen == null) {
            System.out.println("You have chosen to not play a card.");
        } else {
            System.out.println("You have chosen to play " + chosen + ".");
        }
        System.out.println();
        return chosen;
    }

    private void printCards(List<T> cards) {
        System.out.println("Here are your options:");
        System.out.println("-1: not choosing");
        for (int index = 0; index < cards.size(); index++) {
            System.out.println(index + ": " + cards.get(index).toString());
        }
        System.out.println("Please enter an option (-1 - " + (cards.size() - 1) + ") and press enter:");
    }
}

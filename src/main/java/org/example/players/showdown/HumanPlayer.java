package org.example.players.showdown;

public class HumanPlayer extends Player {

    private final CommandLineInterface commandLineInterface;

    public HumanPlayer(CommandLineInterface commandLineInterface) {
        this.commandLineInterface = commandLineInterface;
    }

    @Override
    public void nameHimself() {
        this.name = commandLineInterface.enterName();
    }

    @Override
    public void showCard() {
        this.hand.show(commandLineInterface.showCard(this.hand.lookup()));
    }
}

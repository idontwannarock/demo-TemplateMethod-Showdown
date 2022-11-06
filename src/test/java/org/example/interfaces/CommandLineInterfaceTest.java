package org.example.interfaces;

import org.example.PlayerInterface;
import org.example.showdown.cards.Rank;
import org.example.showdown.cards.ShowdownCard;
import org.example.showdown.cards.Suit;
import org.hamcrest.core.IsNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CommandLineInterfaceTest {

    private final static String RETURN = System.getProperty("line.separator");

    @Rule
    public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private final PlayerInterface<ShowdownCard> playerInterface = new CommandLineInterface<>();

    @Test
    public void givenStringInput_whenEnterName_thenReturnGivenStringInput() {
        // arrange
        String expected = "Howard";
        systemInMock.provideLines(expected);

        // act
        String actual = playerInterface.enterName();

        // assert
        assertThat(actual, is(expected));
        assertThat(systemOutRule.getLog(), is(
                "Please enter your name and press enter:" + RETURN +
                        "Hello " + expected + "!" + RETURN));
    }

    @Test
    public void givenEmptyString_whenEnterName_thenNeedToProvideNotEmptyString() {
        // arrange
        String firstInput = "";
        String secondInput = "Howard";
        systemInMock.provideLines(firstInput, secondInput);

        // act
        String actual = playerInterface.enterName();

        // assert
        assertThat(actual, is(secondInput));
        assertThat(systemOutRule.getLog(), is(
                "Please enter your name and press enter:" + RETURN +
                        "Your must provide a name. Please enter your name and press enter:" + RETURN +
                        "Hello " + secondInput + "!" + RETURN));
    }

    @Test
    public void givenBlankString_whenEnterName_thenNeedToProvideNotBlankString() {
        // arrange
        String firstInput = " ";
        String secondInput = "Howard";
        systemInMock.provideLines(firstInput, secondInput);

        // act
        String actual = playerInterface.enterName();

        // assert
        assertThat(actual, is(secondInput));
        assertThat(systemOutRule.getLog(), is(
                "Please enter your name and press enter:" + RETURN +
                        "Your must provide a name. Please enter your name and press enter:" + RETURN +
                        "Hello " + secondInput + "!" + RETURN));
    }

    @Test
    public void givenNoCardsAtHand_thenReturnNothingToChooseFrom() {
        // act
        ShowdownCard actual = playerInterface.choose(List.of());

        // assert
        assertThat(actual, IsNull.nullValue());
        assertThat(systemOutRule.getLog(), is("You have no cards to choose from." + RETURN));
    }

    @Test
    public void givenOneCardAtHand_whenNotChoosing_thenReturnNull() {
        // arrange
        ShowdownCard expected = new ShowdownCard(Rank.ACE, Suit.SPADE);
        List<ShowdownCard> cards = List.of(expected);
        systemInMock.provideLines("-1");

        // act
        ShowdownCard actual = playerInterface.choose(cards);

        // assert
        assertThat(actual, IsNull.nullValue());
        assertThat(systemOutRule.getLog(), is(
                "Here are your options:" + RETURN +
                        "-1: not choosing" + RETURN +
                        "0: " + expected + RETURN +
                        "Please enter an option (-1 - 0) and press enter:" + RETURN + "" +
                        "You have chosen to not play a card." + RETURN + RETURN));
    }

    @Test
    public void givenOneCardAtHand_whenChoosingThatCard_thenReturnThatCard() {
        // arrange
        ShowdownCard expected = new ShowdownCard(Rank.ACE, Suit.SPADE);
        List<ShowdownCard> cards = List.of(expected);
        systemInMock.provideLines("0");

        // act
        ShowdownCard actual = playerInterface.choose(cards);

        // assert
        assertThat(actual, is(expected));
        assertThat(systemOutRule.getLog(), is(
                "Here are your options:" + RETURN +
                        "-1: not choosing" + RETURN +
                        "0: " + expected + RETURN +
                        "Please enter an option (-1 - 0) and press enter:" + RETURN +
                        "You have chosen to play " + expected + "." + RETURN + RETURN));
    }

    @Test
    public void givenOneCardAtHand_whenChoosingSecondCard_thenWillHaveToChooseAgain() {
        // arrange
        ShowdownCard expected = new ShowdownCard(Rank.ACE, Suit.SPADE);
        List<ShowdownCard> cards = List.of(expected);
        systemInMock.provideLines("1", "0");

        // act
        ShowdownCard actual = playerInterface.choose(cards);

        // assert
        assertThat(actual, is(expected));
        assertThat(systemOutRule.getLog(), is(
                "Here are your options:" + RETURN +
                        "-1: not choosing" + RETURN +
                        "0: " + expected + RETURN +
                        "Please enter an option (-1 - 0) and press enter:" + RETURN +
                        "You have picked a wrong option. Please choose again." + RETURN +
                        "Here are your options:" + RETURN +
                        "-1: not choosing" + RETURN +
                        "0: " + expected + RETURN +
                        "Please enter an option (-1 - 0) and press enter:" + RETURN +
                        "You have chosen to play " + expected + "." + RETURN + RETURN));
    }
}

package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.showdown.ShowdownGame;
import org.example.showdown.players.ShowdownHumanPlayer;
import org.example.uno.UnoGame;
import org.example.uno.players.UnoHumanPlayer;

/**
 * Unit test for simple App.
 */
public class DemoTemplateMethodApplicationTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DemoTemplateMethodApplicationTest(String testName) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( DemoTemplateMethodApplicationTest.class );
    }

    public void testShowdownGame() {
        new ShowdownGame()
                .join(new ShowdownHumanPlayer())
                .start();
    }

    public void testUnoGame() {
        new UnoGame()
                .join(new UnoHumanPlayer())
                .start();
    }
}

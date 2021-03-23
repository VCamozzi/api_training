package fr.esiea.ex4A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    @Test
    void getName() {
        Match match = new Match("eric", "@ericzemour");
        Assertions.assertEquals("eric", match.getName());
    }

    @Test
    void getTwitter() {
        Match match = new Match("eric", "@ericzemour");
        Assertions.assertEquals("ericzemour", match.getTwitter());
    }
}

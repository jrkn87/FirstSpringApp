package pl.duhc.springstart.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CastleTest {

    @Test
    public void castleTest() {
        String except = "Zamek BLACK TIDE Wita!\n" +
                "Zamek obecnie zamieszkuję rycerz o imieniu PERSIVAL( 21 ). Aktualne zadanie: Uratuj Księżniczkę!";

        Quest quest = new Quest();
        Knight knight = new Knight("PERSIVAL", 21);
        knight.setQuest(quest);
        Castle castle = new Castle(knight , "BLACK TIDE");
        assertEquals(except, castle.toString());
    }
}

package pl.duhc.springstart.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KnightTest {

    @Test
    public void testSetQuest(){
        Knight knight = new Knight("Persival", 29);
        Quest quest = new Quest(1, "Kill the dragon!!");

        knight.setQuest(quest);

        assertTrue(knight.getQuest().isStarted());
    }
}

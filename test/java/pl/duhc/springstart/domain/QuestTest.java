package pl.duhc.springstart.domain;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class QuestTest {

    @Test
    public void questSetStartedTest() {
        Quest quest = new Quest(1, "Test task");
        assertFalse(quest.isStarted());
        quest.setStarted(true);
        assertTrue(quest.isStarted());
        assertNotNull(quest.startQuest);
    }

    @Test
    public void questIsComplited() {
        Quest quest = new Quest(1, "Test task");
        quest.setQuestLenght(-1);
        quest.setStarted(true);

        assertTrue(quest.isComplited());
        assertTrue(quest.isComplited());
    }

    @Test
    public void questIsNotComplited() {
        Quest quest = new Quest(1, "Test task");
        quest.setQuestLenght(1);
        quest.setStarted(true);

        assertFalse(quest.isComplited());
        assertFalse(quest.isComplited());
    }
}

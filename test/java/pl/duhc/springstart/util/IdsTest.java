package pl.duhc.springstart.util;

import org.junit.Test;
import pl.duhc.springstart.utils.Ids;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class IdsTest {
    Set<Integer> lastId = new HashSet<>();

    @Test
    public void testEmptySet() {
        Integer expected = 0;

        assertEquals(expected, Ids.addNewId(lastId));
    }

    @Test
    public void test() {
        lastId.add(2);
        lastId.add(1);
        lastId.add(6);
        Integer expect = 7;

        assertEquals(expect, Ids.addNewId(lastId));
    }
}

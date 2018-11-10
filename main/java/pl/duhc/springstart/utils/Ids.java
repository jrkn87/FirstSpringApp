package pl.duhc.springstart.utils;

import java.util.Comparator;
import java.util.Set;

public class Ids {

    static public Integer addNewId(Set<Integer> lastId) {
        if (lastId.isEmpty()) {
            return 0;
        }
        else {
            Integer integer = lastId.stream().max(Comparator.comparing(Integer::valueOf)).get();
            return ++integer;
        }
    }
}

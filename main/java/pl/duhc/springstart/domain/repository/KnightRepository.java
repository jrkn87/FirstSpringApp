package pl.duhc.springstart.domain.repository;

import pl.duhc.springstart.domain.Knight;
import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {
    void createKnight(String name, int age);

    void deleteKnight(Integer id);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void init();

    Knight getKnightById(Integer id);

    default void updateKnight(Integer id, Knight knight) {
        System.out.println("Brak implementacji");
    }
}

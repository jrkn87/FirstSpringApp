package pl.duhc.springstart.domain.repository;

import pl.duhc.springstart.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;

public interface KnightRepository {
    void createKnight(String name, int age);

    void deleteKnight(String name);

    Collection<Knight> getAllKnights();

    Knight getKnight(String name);

    @PostConstruct
    void init();
}

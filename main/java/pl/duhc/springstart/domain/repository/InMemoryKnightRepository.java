package pl.duhc.springstart.domain.repository;

import org.springframework.stereotype.Repository;
import pl.duhc.springstart.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryKnightRepository implements KnightRepository {

    Map<String, Knight> knights = new HashMap<>();

    public InMemoryKnightRepository() {

    }

    @Override
    public void createKnight(String name, int age){
        knights.put(name, new Knight(name, age));
    }

    @Override
    public void deleteKnight(String name) {
        knights.remove(name);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Knight getKnight(String name) {
        return knights.get(name);
    }

    @Override
    @PostConstruct
    public void init() {
        createKnight("Lancelot", 21);
        createKnight("Persival", 27);
    }

    @Override
    public String toString() {
        return "InMemoryKnightRepository{" +
                "knights=" + knights +
                '}';
    }
}

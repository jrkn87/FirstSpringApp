package pl.duhc.springstart.domain.repository;

import org.springframework.stereotype.Repository;
import pl.duhc.springstart.domain.Knight;
import pl.duhc.springstart.utils.Ids;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class InMemoryKnightRepository implements KnightRepository {

    Map<Integer, Knight> knights = new HashMap<>();

    public InMemoryKnightRepository() {

    }

    @Override
    public void createKnight(String name, int age){
        Knight newKnight = new Knight(name, age);
        newKnight.setId(Ids.addNewId(knights.keySet()));
        knights.put(newKnight.getId(), newKnight);
    }

    @Override
    public void deleteKnight(Integer id) {
        knights.remove(id);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Optional<Knight> knight = knights.values().stream().filter(knight1 -> knight1.getName().equals(name)).findAny();
        return knight;
    }

    @Override
    @PostConstruct
    public void init() {
        createKnight("Lancelot", 21);
        createKnight("Persival", 27);
        createKnight("Maveric", 17);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }

    @Override
    public String toString() {
        return "InMemoryKnightRepository{" +
                "knights=" + knights +
                '}';
    }
}

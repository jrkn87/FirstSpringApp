package pl.duhc.springstart.domain.repository;

import org.springframework.stereotype.Repository;
import pl.duhc.springstart.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryKnightRepository implements KnightRepository {

    Map<Integer, Knight> knights = new HashMap<>();

    public InMemoryKnightRepository() {

    }

    @Override
    public void createKnight(String name, int age){
        Knight newKnight = new Knight(name, age);
        newKnight.setId(addNewId());
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

    public Integer addNewId() {
        if (knights.isEmpty()) {
            return 0;
        }
        else {
            Integer integer = knights.keySet().stream().max(Integer::max).get();
            return integer + 1;
        }
    }
}

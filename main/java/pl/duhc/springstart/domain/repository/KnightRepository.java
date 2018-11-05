package pl.duhc.springstart.domain.repository;

import org.springframework.stereotype.Repository;
import pl.duhc.springstart.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class KnightRepository {

    Map<String, Knight> knights = new HashMap<>();

    public KnightRepository() {

    }

    public void createKnight(String name, int age){
        knights.put(name, new Knight(name, age));
    }

    public void deleteKnight(String name) {
        knights.remove(name);
    }

    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    public Knight getKnight(String name) {
        return knights.get(name);
    }

    @PostConstruct
    public void init() {
        createKnight("Lancelot", 21);
        createKnight("Persival", 27);
    }

    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knights +
                '}';
    }
}

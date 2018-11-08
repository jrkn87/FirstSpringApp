package pl.duhc.springstart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.duhc.springstart.domain.Knight;
import pl.duhc.springstart.domain.repository.KnightRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    public List<Knight> getAllKnights() {
        return new ArrayList<>(knightRepository.getAllKnights());
    }

    public void createKnight(Knight knight) {
        knightRepository.createKnight(knight.getName(), knight.getAge());
    }

    public Knight getKnight(Integer id) {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }
}

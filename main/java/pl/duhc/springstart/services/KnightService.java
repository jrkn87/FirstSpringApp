package pl.duhc.springstart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.duhc.springstart.domain.Knight;
import pl.duhc.springstart.domain.PlayerInfo;
import pl.duhc.springstart.domain.repository.KnightRepository;
import pl.duhc.springstart.domain.repository.PlayerInfoRepository;
import pl.duhc.springstart.domain.repository.QuestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    PlayerInfoRepository playerInfoRepository;

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

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectReward() {
        Predicate<Knight> knightPredicate = knight -> {
            if (knight.getQuest() != null) {
                return knight.getQuest().isComplited();
            } else {
                return false;
            }};

        int sum = knightRepository.getAllKnights().stream().filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward()).sum();

        knightRepository.getAllKnights().stream().filter(knightPredicate)
                .forEach(knight -> knight.setQuest(null));

        return sum;
    }

    @Transactional
    public void getMyGold() {
        getAllKnights().forEach(knight -> {
            if (knight.getQuest()!=null) {
                boolean complited = knight.getQuest().isComplited();
                if (complited)
                    questRepository.updateQuest(knight.getQuest());
            }
        });
        int currentReward = playerInfoRepository.getFirst().getGoldValue();
        playerInfoRepository.getFirst().setGoldValue(currentReward + collectReward());
    }
}

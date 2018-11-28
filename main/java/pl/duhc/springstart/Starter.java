package pl.duhc.springstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.duhc.springstart.domain.Knight;
import pl.duhc.springstart.domain.PlayerInfo;
import pl.duhc.springstart.domain.repository.KnightRepository;
import pl.duhc.springstart.domain.repository.PlayerInfoRepository;
import pl.duhc.springstart.domain.repository.QuestRepository;
import pl.duhc.springstart.services.QuestService;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    PlayerInfoRepository playerInfoRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("\n\n");


        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Persival", 21);

        playerInfoRepository.createPlayerInfo();

        //System.out.println("\n\n");
    }
}

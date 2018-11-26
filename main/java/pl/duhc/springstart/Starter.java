package pl.duhc.springstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.duhc.springstart.domain.repository.KnightRepository;
import pl.duhc.springstart.domain.repository.QuestRepository;
import pl.duhc.springstart.services.QuestService;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\n");


        questRepository.createRandomQuest();
        questRepository.createRandomQuest();


        System.out.println("\n\n");
    }
}

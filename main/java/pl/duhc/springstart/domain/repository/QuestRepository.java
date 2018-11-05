package pl.duhc.springstart.domain.repository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import pl.duhc.springstart.domain.Quest;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class QuestRepository {

    List<Quest> questsList = new ArrayList<>();
    final static Random rand = new Random();

    public void createQuest(String description) {
        questsList.add(new Quest(description));
    }

    public void deleteQuest(Quest quest) {
        questsList.remove(quest);
    }

    public List<Quest> getAllQuest() {
        return questsList;
    }

    @Scheduled(fixedDelayString = "${questdelay.value}")
    public void createRandomQuest() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Rescue the Princes!");
        descriptions.add("Kill the dragon.");
        descriptions.add("Kill goblins band.");
        descriptions.add("Find a gold key nea..");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        System.out.println(description);

        createQuest(description);
    }

    @PostConstruct
    public void init() {

    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questsList=" + questsList +
                '}';
    }
}

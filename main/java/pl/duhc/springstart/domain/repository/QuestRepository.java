package pl.duhc.springstart.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.duhc.springstart.components.TimeComponent;
import pl.duhc.springstart.domain.Quest;
import pl.duhc.springstart.utils.Ids;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class QuestRepository {

    @PersistenceContext
    private EntityManager em;

    final static Random rand = new Random();

    @Transactional
    public void createQuest(String description) {
        Quest quest = new Quest(description);
        em.persist(quest);
    }

    @Transactional
    public void deleteQuest(Quest quest) {
        em.remove(quest);
    }

    public List<Quest> getAllQuest() {
        return em.createQuery("from Quest", Quest.class).getResultList();
    }

    @Transactional
    public void updateQuest(Quest quest) {
        em.merge(quest);
    }

    @Scheduled(fixedDelayString = "${questdelay.value}")
    @Transactional
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

    public Quest getId(Integer id) {
        return em.find(Quest.class, id);
    }
}

package pl.duhc.springstart.domain.repository;

import org.springframework.transaction.annotation.Transactional;
import pl.duhc.springstart.domain.Knight;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

public class KnightRepository_DB implements KnightRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void createKnight(String name, int age) {
        em.persist(new Knight(name, age));
    }

    @Override
    @Transactional
    public void deleteKnight(Integer id) {
        em.remove(id);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return em.createQuery("from Knight", Knight.class).getResultList();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Knight knightByName = em.createQuery("from Knight k where k.name=:name", Knight.class).setParameter("name", name).getSingleResult();
        return Optional.ofNullable(knightByName);
    }

    @Override
    public void init() {

    }

    @Override
    public Knight getKnightById(Integer id) {
        return em.find(Knight.class, id);
    }

    @Override
    @Transactional
    public void updateKnight(Integer id, Knight knight) {
        em.merge(knight);
    }
}

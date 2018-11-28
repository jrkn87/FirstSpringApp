package pl.duhc.springstart.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.duhc.springstart.domain.PlayerInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PlayerInfoRepository {

    @PersistenceContext
    EntityManager em;

    public PlayerInfo getFirst() {
        return em.createQuery("from PlayerInfo", PlayerInfo.class).getResultList().get(0);
    }

    @Transactional
    public void createPlayerInfo() {
        PlayerInfo playerInfo = new PlayerInfo();
        em.persist(playerInfo);
    }
}

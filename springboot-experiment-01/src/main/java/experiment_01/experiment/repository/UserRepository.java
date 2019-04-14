package experiment_01.experiment.repository;


import experiment_01.experiment.entity.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public void addUserAddress() {
        User user = new User("zds");
        em.persist(user);
        Address ad1 = new Address("11b");
        ad1.setUser(user);
        em.persist(ad1);
        Address ad2 = new Address("NeiMengGu");
        ad2.setUser(user);
        em.persist(ad2);
    }
}

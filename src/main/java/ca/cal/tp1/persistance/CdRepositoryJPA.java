package ca.cal.tp1.persistance;

import ca.cal.tp1.modele.Cd;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CdRepositoryJPA implements InterfaceRepository<Cd> {
    private final EntityManagerFactory entityManagerFactory=
            Persistence.createEntityManagerFactory("orders.pu");
    @Override
    public void save(Cd cd) {

        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            entityManager.persist(cd);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public Cd get(Long id) {

        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

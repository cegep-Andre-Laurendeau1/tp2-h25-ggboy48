package ca.cal.tp1.persistance;

import ca.cal.tp1.modele.Cd;
import ca.cal.tp1.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

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
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            TypedQuery<Cd> query = entityManager.createQuery(
                    "SELECT cd FROM Cd cd " +
                            "WHERE cd.id = :id", Cd.class);
            query.setParameter("id", id);
            query.getSingleResult();
            entityManager.getTransaction().commit();
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }    }

    @Override
    public void delete(Long id) {

    }
}

package ca.cal.tp1.persistance;

import ca.cal.tp1.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class LivreRepositoryJPA implements InterfaceRepository<Livre> {
    final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("orders.pu");
    @Override
    public void save(Livre livre) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            entityManager.persist(livre);
            entityManager.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Livre get(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            TypedQuery<Livre> query = entityManager.createQuery(
                    "SELECT livre FROM Livre livre " +
                            "WHERE livre.id = :id", Livre.class);
            query.setParameter("id", id);
            query.getSingleResult();
            entityManager.getTransaction().commit();
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(Long id) {

    }
}

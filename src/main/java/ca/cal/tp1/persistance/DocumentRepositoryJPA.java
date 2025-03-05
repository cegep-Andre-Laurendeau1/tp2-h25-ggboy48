package ca.cal.tp1.persistance;

import ca.cal.tp1.modele.Document;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class DocumentRepositoryJPA implements InterfaceRepository<Document> {
    private final EntityManagerFactory entityManagerFactory=
            Persistence.createEntityManagerFactory("orders.pu");
    @Override
    public void save(Document document) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            if(get(document.getId()) != null){
                entityManager.merge(document);
            }
            else {
                entityManager.persist(document);
            }

            entityManager.getTransaction().commit();
        }
    }

    @Override
    public Document get(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            TypedQuery<Document> query = entityManager.createQuery(
                    "SELECT document FROM Document document " +
                            "WHERE document.id = :id", Document.class);
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

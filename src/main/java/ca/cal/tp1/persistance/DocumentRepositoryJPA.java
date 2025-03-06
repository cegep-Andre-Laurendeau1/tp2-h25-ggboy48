package ca.cal.tp1.persistance;

import ca.cal.tp1.modele.Document;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

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
    public List<Document> get(String titreSubString, LocalDate annePublication) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            TypedQuery<Document> query = entityManager.createQuery(
                    "SELECT document FROM Document document " +
                            "WHERE document.titre LIKE :titreSubString " +
                            "AND document.anneePublication = :anneePublication ", Document.class);
            query.setParameter("titreSubString", "%"+titreSubString+"%");
            query.setParameter("anneePublication", annePublication);
            entityManager.getTransaction().commit();
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Document> get(String titreSubString) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            TypedQuery<Document> query = entityManager.createQuery(
                    "SELECT document FROM Document document " +
                            "WHERE document.titre LIKE :titreSubString ", Document.class);
            query.setParameter("titreSubString", "%"+titreSubString+"%");
            entityManager.getTransaction().commit();
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Document> get(LocalDate annePublication) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            TypedQuery<Document> query = entityManager.createQuery(
                    "SELECT document FROM Document document " +
                            "WHERE document.anneePublication = :anneePublication ", Document.class);
            query.setParameter("anneePublication", annePublication);
            entityManager.getTransaction().commit();
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class DocumentRepositoryJPA implements DocumentRepository {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("alrik.pu");

    @Override
    public void save(Document document) throws DuplicateEntityException {
        try(EntityManager entityManager = emf.createEntityManager();) {
            entityManager.getTransaction().begin();
            entityManager.persist(document);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            throw new DuplicateEntityException(e.getMessage());
        }
    }

    @Override
    public Livre rechercheLivre(String titre, String auteur, Integer anneePublication) throws DuplicateEntityException {
        try (EntityManager entityManager = emf.createEntityManager()) {
            String query = "SELECT l FROM Livre l WHERE l.titre = :titre AND l.auteur = :auteur AND l.anneePublication = :anneePublication";
            TypedQuery<Livre> typedQuery = entityManager.createQuery(query, Livre.class);
            typedQuery.setParameter("titre", titre);
            typedQuery.setParameter("auteur", auteur);
            typedQuery.setParameter("anneePublication", anneePublication);
            return typedQuery.getSingleResult();  // Renvoie un seul livre correspondant à la recherche
        } catch (RuntimeException e) {
            throw new DuplicateEntityException("Erreur lors de la recherche du livre : " + e.getMessage());
        }
    }

    @Override
    public CD rechercheCD(String titre, String artiste) throws DuplicateEntityException {
        try (EntityManager entityManager = emf.createEntityManager()) {
            String query = "SELECT c FROM CD c WHERE c.titre = :titre AND c.artiste = :artiste";
            TypedQuery<CD> typedQuery = entityManager.createQuery(query, CD.class);
            typedQuery.setParameter("titre", titre);
            typedQuery.setParameter("artiste", artiste);
            return typedQuery.getSingleResult();  // Renvoie un seul CD correspondant à la recherche
        } catch (RuntimeException e) {
            throw new DuplicateEntityException("Erreur lors de la recherche du CD : " + e.getMessage());
        }
    }

    @Override
    public DVD rechercheDVD(String titre, String directeur) throws DuplicateEntityException {
        try (EntityManager entityManager = emf.createEntityManager()) {
            String query = "SELECT d FROM DVD d WHERE d.titre = :titre AND d.directeur = :directeur";
            TypedQuery<DVD> typedQuery = entityManager.createQuery(query, DVD.class);
            typedQuery.setParameter("titre", titre);
            typedQuery.setParameter("directeur", directeur);
            return typedQuery.getSingleResult();  // Renvoie un seul DVD correspondant à la recherche
        } catch (RuntimeException e) {
            throw new DuplicateEntityException("Erreur lors de la recherche du DVD : " + e.getMessage());
        }
    }
}

package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DataErrorHandler;
import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.*;

public class DocumentRepositoryJPA implements DocumentRepository {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("alrik.pu");

    @Override
    public void save(Document document) throws DuplicateEntityException {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(document);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new DuplicateEntityException(e.getMessage());
        } finally {
            entityManager.close(); // Fermer après la transaction
        }
    }


    @Override
    public Livre rechercheLivre(String titre, String auteur, Integer anneePublication) throws DataErrorHandler {
        try (EntityManager entityManager = emf.createEntityManager()) {
            String sql = "SELECT l FROM Livre l WHERE 1=1";
            if (titre != null && !titre.isEmpty()) {
                sql += " AND LOWER(l.titre) LIKE LOWER(:titre)";
            }
            if (auteur != null && !auteur.isEmpty()) {
                sql += " AND LOWER(l.auteur) = LOWER(:auteur)";
            }
            if (anneePublication != null) {
                sql += " AND l.anneePublication = :anneePublication";
            }

            TypedQuery<Livre> typedQuery = entityManager.createQuery(sql, Livre.class);

            if (titre != null && !titre.isEmpty()) {
                typedQuery.setParameter("titre", "%" + titre + "%");
            }
            if (auteur != null && !auteur.isEmpty()) {
                typedQuery.setParameter("auteur", auteur);
            }
            if (anneePublication != null) {
                typedQuery.setParameter("anneePublication", anneePublication);
            }

            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null; // Pas d'erreur, mais pas de résultat
        } catch (RuntimeException e) {
            throw new DataErrorHandler(e);
        }
    }


    @Override
    public CD rechercheCd(String titre, String artiste) throws DataErrorHandler {
        return null;
    }

    @Override
    public DVD rechercheDvd(String titre, String realisateur) throws DataErrorHandler {
        return null;
    }



}

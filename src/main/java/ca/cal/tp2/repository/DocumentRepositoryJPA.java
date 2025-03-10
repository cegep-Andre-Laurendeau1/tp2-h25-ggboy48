package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DataErrorHandler;
import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.*;

import java.util.List;

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
        // Vérification des paramètres avec logs
        System.out.println("Recherche de livre avec les paramètres :");
        System.out.println("Titre : " + titre);
        System.out.println("Auteur : " + auteur);
        System.out.println("Année : " + anneePublication);

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


            System.out.println("Requête SQL générée : " + sql);

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


            List<Livre> livres = typedQuery.getResultList();
            System.out.println("Nombre de résultats : " + livres.size());
            if (livres.isEmpty()) {
                System.out.println("Aucun livre trouvé.");
                return null;
            } else {
                return livres.get(0);
            }

        } catch (RuntimeException e) {
            System.out.println("Erreur lors de l'exécution de la requête : " + e.getMessage());
            throw new DataErrorHandler("Erreur, on ne trouve pas de résultat");
        }
    }



    @Override
    public CD rechercheCd(String titre, String artiste) throws DataErrorHandler {
        // Vérification des paramètres
        System.out.println("Recherche de CD avec les paramètres :");
        System.out.println("Titre : " + titre);
        System.out.println("Artiste : " + artiste);

        try (EntityManager entityManager = emf.createEntityManager()) {
            String sql = "SELECT c FROM CD c WHERE 1=1";

            if (titre != null && !titre.isEmpty()) {
                sql += " AND LOWER(c.titre) LIKE LOWER(:titre)";
            }
            if (artiste != null && !artiste.isEmpty()) {
                sql += " AND LOWER(c.artiste) = LOWER(:artiste)";
            }

            System.out.println("Requête SQL générée : " + sql);

            TypedQuery<CD> typedQuery = entityManager.createQuery(sql, CD.class);

            if (titre != null && !titre.isEmpty()) {
                typedQuery.setParameter("titre", "%" + titre + "%");
            }
            if (artiste != null && !artiste.isEmpty()) {
                typedQuery.setParameter("artiste", artiste);
            }

            List<CD> cds = typedQuery.getResultList();
            System.out.println("Nombre de résultats : " + cds.size());
            if (cds.isEmpty()) {
                System.out.println("Aucun CD trouvé.");
                return null;
            } else {
                return cds.get(0);  // Retourne le premier CD trouvé
            }

        } catch (RuntimeException e) {
            System.out.println("Erreur lors de l'exécution de la requête : " + e.getMessage());
            throw new DataErrorHandler("Erreur, on ne trouve pas de résultat");
        }
    }

    @Override
    public DVD rechercheDvd(String titre, String directeur) throws DataErrorHandler {
        // Vérification des paramètres
        System.out.println("Recherche de DVD avec les paramètres :");
        System.out.println("Titre : " + titre);
        System.out.println("Directeur : " + directeur);

        try (EntityManager entityManager = emf.createEntityManager()) {
            String sql = "SELECT d FROM DVD d WHERE 1=1";

            if (titre != null && !titre.isEmpty()) {
                sql += " AND LOWER(d.titre) LIKE LOWER(:titre)";
            }
            if (directeur != null && !directeur.isEmpty()) {
                sql += " AND LOWER(d.directeur) = LOWER(:directeur)";
            }

            System.out.println("Requête SQL générée : " + sql);

            TypedQuery<DVD> typedQuery = entityManager.createQuery(sql, DVD.class);

            if (titre != null && !titre.isEmpty()) {
                typedQuery.setParameter("titre", "%" + titre + "%");
            }
            if (directeur != null && !directeur.isEmpty()) {
                typedQuery.setParameter("directeur", directeur);
            }

            List<DVD> dvds = typedQuery.getResultList();
            System.out.println("Nombre de résultats : " + dvds.size());
            if (dvds.isEmpty()) {
                System.out.println("Aucun DVD trouvé.");
                return null;
            } else {
                return dvds.get(0);  // Retourne le premier DVD trouvé
            }

        } catch (RuntimeException e) {
            System.out.println("Erreur lors de l'exécution de la requête : " + e.getMessage());
            throw new DataErrorHandler("Erreur, on ne trouve pas de résultat");
        }
    }




}

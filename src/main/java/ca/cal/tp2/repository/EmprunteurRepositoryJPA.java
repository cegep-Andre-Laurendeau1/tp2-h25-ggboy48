package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.*;

public class EmprunteurRepositoryJPA implements EmprunteurRepository {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("alrik.pu");
    @Override
    public void save(Emprunteur emprunteur) throws DuplicateEntityException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(emprunteur);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            throw new DuplicateEntityException(e.getMessage());
        }
    }

    @Override
    public Emprunteur getByNomPrenomEmail(String nom, String prenom, String email) throws EntityNotFoundException {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Emprunteur> query = em.createQuery(
                    "SELECT e FROM Emprunteur e " +
                            "LEFT JOIN FETCH e.emprunts " +  // Charge les emprunts en même temps
                            "LEFT JOIN FETCH e.amendes " +  // Charge aussi les amendes
                            "WHERE e.nom = :nom AND e.prenom = :prenom AND e.email = :email",
                    Emprunteur.class
            );

            query.setParameter("nom", nom);
            query.setParameter("prenom", prenom);
            query.setParameter("email", email);

            try {
                return query.getSingleResult();
            } catch (NoResultException e) {
                throw new EntityNotFoundException("Emprunteur non trouvé avec ces informations.");
            }
        }
    }





}

package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;

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
    public Emprunteur getByEmail(String nom,String prenom, String email) throws EntityNotFoundException {

        // Vérification des paramètres
        System.out.println("Recherche l'emprunteur avec les paramètres :");
        System.out.println("nom : " + nom);
        System.out.println("prenom : " + prenom);
        System.out.println("Email : " + email);


        try (EntityManager em = emf.createEntityManager()) {
            Emprunteur emprunteur = em.find(Emprunteur.class, email);
            if (emprunteur == null) {
                throw new EntityNotFoundException("Emprunteur non trouvé avec le courriel : " + email);
            }
            return emprunteur;
        }
    }
}

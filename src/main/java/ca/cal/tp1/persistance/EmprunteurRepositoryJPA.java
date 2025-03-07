package ca.cal.tp1.persistance;

import ca.cal.tp1.modele.Cd;
import ca.cal.tp1.modele.Emprunt;
import ca.cal.tp1.modele.Emprunteur;
import ca.cal.tp1.service.EmprunteurService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class EmprunteurRepositoryJPA implements InterfaceRepository<Emprunteur> {
    private final EntityManagerFactory entityManagerFactory=
            Persistence.createEntityManagerFactory("orders.pu");
    @Override
    public void save(Emprunteur emprunteur) {

        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            entityManager.persist(emprunteur);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public Emprunteur get(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            TypedQuery<Emprunteur> query = entityManager.createQuery(
                    "SELECT emprunteur FROM Emprunteur emprunteur " +
                            "WHERE emprunteur.id = :id", Emprunteur.class);
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
    public List<Emprunteur> get(String titreSubString, LocalDate annePublication) {
        return List.of();
    }

    @Override
    public List<Emprunteur> get(String titreSubString) {
        return List.of();
    }

    @Override
    public List<Emprunteur> get(LocalDate annePublication) {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Emprunteur> get(Emprunteur emprunteur) {
        return List.of();
    }

    @Override
    public List<Emprunteur> get(Emprunt emprunt) {
        return List.of();
    }
}

package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;

public class LivreRepositoryJPA implements LivreRepository {
  private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("alrik.pu");

}

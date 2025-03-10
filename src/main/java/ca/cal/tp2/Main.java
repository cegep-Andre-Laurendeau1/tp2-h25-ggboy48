package ca.cal.tp2;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.*;
import ca.cal.tp2.service.LivreService;
import ca.cal.tp2.service.PreposeService;
import ca.cal.tp2.utils.TcpServer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException, DuplicateEntityException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate2.ex1");
        EntityManager em = emf.createEntityManager();

        // Créer les repository nécessaires pour PreposeService
        LivreRepository livreRepository = new LivreRepositoryJPA(em);
        CDRepository cdRepository = new CDRepositoryJPA(em);
        DVDRepository dvdRepository = new DVDRepositoryJPA(em);
        DocumentRepository documentRepository = new DocumentRepositoryJPA(em);

        // Créer le service PreposeService
        PreposeService preposeService = new PreposeService(livreRepository, cdRepository, dvdRepository, documentRepository);

        // Ajouter un livre via PreposeService
        preposeService.ajouterLivre(1, "Le Petit Prince", "Antoine de Saint-Exupéry", 1943, 14, 5, "978-2-123456-78-9", "Éditeur X", 120);

        // Rechercher le livre par ID via PreposeService


        // Fermer l'EntityManager et l'EntityManagerFactory
        em.close();
        emf.close();
    }
}

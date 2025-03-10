package ca.cal.tp2;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.*;
import ca.cal.tp2.service.CDService;
import ca.cal.tp2.service.DVDService;
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
        LivreRepository livreRepository = new LivreRepositoryJPA();
        CDRepository cdRepository = new CDRepositoryJPA(em);
        DVDRepository dvdRepository = new DVDRepositoryJPA(em);


        // Créer les services
        LivreService livreService = new LivreService(livreRepository);
        CDService cdService = new CDService(cdRepository);
        DVDService dvdService = new DVDService(dvdRepository);

        // Créer le service PreposeService
        PreposeService preposeService = new PreposeService(livreService,cdService,dvdService);

        // Ajouter un livre via PreposeService
        preposeService.ajouterLivre(1, "Le Petit Prince", "Antoine de Saint-Exupéry", 1943, 14, 5, "978-2-123456-78-9", "Éditeur X", 120);

        // Rechercher le livre par ID via PreposeService


        // Fermer l'EntityManager et l'EntityManagerFactory
        em.close();
        emf.close();
    }
}

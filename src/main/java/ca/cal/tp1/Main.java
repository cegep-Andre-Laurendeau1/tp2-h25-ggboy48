package ca.cal.tp1;

import ca.cal.tp1.persistance.CdRepositoryJDBC;
import ca.cal.tp1.persistance.DvdRepositoryJDBC;
import ca.cal.tp1.persistance.LivreRepositoryJDBC;
import ca.cal.tp1.service.EmprunteurService;

import java.time.LocalDate;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {
        // Votre script qui utilise votre API ici
        TcpServer.startTcpServer();

        EmprunteurService emprunteurServiceJDBC = new EmprunteurService(new CdRepositoryJDBC(), new DvdRepositoryJDBC(), new LivreRepositoryJDBC());
        EmprunteurService emprunteurServiceJPA = new EmprunteurService(new CdRepositoryJPA(), new DvdRepositoryJPA(), new LivreRepositoryJPA());



        emprunteurServiceJDBC.saveLivre(1,"titre JDBC", LocalDate.of(2021, 1, 1),1,"ISBN","auteur","editeur",1);
        System.out.println(emprunteurServiceJDBC.getLivre(1));

        emprunteurServiceJDBC.saveCd(1,"titre JDBC",LocalDate.of(2022, 1, 1),1,"artiste",1, "genre");
        System.out.println(emprunteurServiceJDBC.getCd(1));

        emprunteurServiceJDBC.saveDvd(1,"titre JDBC",LocalDate.of(2023, 1, 1),1,"directeur", 1, "genre");
        System.out.println(emprunteurServiceJDBC.getDvd(1));



        emprunteurServiceJPA.saveLivre(2,"titre JPA", LocalDate.of(2021, 1, 1),1,"ISBN","auteur","editeur",1);
        System.out.println(emprunteurServiceJPA.getLivre(2));

        emprunteurServiceJPA.saveCd(2,"titre JPA",LocalDate.of(2022, 1, 1),1,"artiste",1, "genre");
        System.out.println(emprunteurServiceJPA.getCd(2));

        emprunteurServiceJPA.saveDvd(2,"titre JPA",LocalDate.of(2023, 1, 1),1,"directeur", 1, "genre");
        System.out.println(emprunteurServiceJPA.getDvd(2));

        emprunteurServiceJPA.ajouterClient();
        emprunteurServiceJPA.rechercheLivre();
        emprunteurServiceJPA.rechercheCd();
        emprunteurServiceJPA.rechercheDvd();
        emprunteurServiceJPA.emprunterLivre();
        emprunteurServiceJPA.emprunterCd();
        emprunteurServiceJPA.emprunterDvd();
        emprunteurServiceJPA.getDocumentsEmprunteur();



        Thread.currentThread().join();
    }
}
package ca.cal.tp1;

import ca.cal.tp1.persistance.*;
import ca.cal.tp1.service.EmprunteurService;

import java.time.LocalDate;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {
        // Votre script qui utilise votre API ici
        TcpServer.startTcpServer();

        //EmprunteurService emprunteurServiceJDBC = new EmprunteurService(new CdRepositoryJDBC(), new DvdRepositoryJDBC(), new LivreRepositoryJDBC());
        EmprunteurService emprunteurServiceJPA = new EmprunteurService(new CdRepositoryJPA(), new DvdRepositoryJPA(), new LivreRepositoryJPA(), new EmprunteurRepositoryJPA());



//        emprunteurServiceJDBC.saveLivre("titre JDBC", LocalDate.of(2021, 1, 1),1,"ISBN","auteur","editeur",1);
//        System.out.println(emprunteurServiceJDBC.getLivre(1L));
//
//        emprunteurServiceJDBC.saveCd("titre JDBC",LocalDate.of(2022, 1, 1),1,"artiste",1, "genre");
//        System.out.println(emprunteurServiceJDBC.getCd(1L));
//
//        emprunteurServiceJDBC.saveDvd("titre JDBC",LocalDate.of(2023, 1, 1),1,"directeur", 1, "genre");
//        System.out.println(emprunteurServiceJDBC.getDvd(1L));



        emprunteurServiceJPA.saveLivre("titre JPA", LocalDate.of(2021, 1, 1),1,"ISBN","auteur","editeur",1);
        System.out.println(emprunteurServiceJPA.getLivre(1L));

        emprunteurServiceJPA.saveCd("titre JPA",LocalDate.of(2022, 1, 1),1,"artiste",1, "genre");
        System.out.println(emprunteurServiceJPA.getCd(2L));

        emprunteurServiceJPA.saveDvd("titre JPA",LocalDate.of(2023, 1, 1),1,"directeur", 1, "genre");
        System.out.println(emprunteurServiceJPA.getDvd(52L));

        emprunteurServiceJPA.ajouterEmprunteur("nom", "email", "numTelephone");
//        emprunteurServiceJPA.rechercheLivre();
//        emprunteurServiceJPA.rechercheCd();
//        emprunteurServiceJPA.rechercheDvd();
//        emprunteurServiceJPA.emprunterLivre();
//        emprunteurServiceJPA.emprunterCd();
//        emprunteurServiceJPA.emprunterDvd();
//        emprunteurServiceJPA.getDocumentsEmprunteur();



        Thread.currentThread().join();
    }
}
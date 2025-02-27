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


        emprunteurServiceJDBC.ajouterLivre(1,"titre", LocalDate.of(2021, 1, 1),1,"ISBN","auteur","editeur",1);
        System.out.println(emprunteurServiceJDBC.getLivre(1));

        emprunteurServiceJDBC.ajouterCd(1,"titre",LocalDate.of(2022, 1, 1),1,"artiste",1, "genre");
        System.out.println(emprunteurServiceJDBC.getCd(1));

        emprunteurServiceJDBC.ajouterDvd(1,"titre",LocalDate.of(2023, 1, 1),1,"directeur", 1, "genre");
        System.out.println(emprunteurServiceJDBC.getDvd(1));


        Thread.currentThread().join();
    }
}
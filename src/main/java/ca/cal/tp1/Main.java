package ca.cal.tp1;

import ca.cal.tp1.persistance.CdRepository;
import ca.cal.tp1.persistance.DvdRepository;
import ca.cal.tp1.persistance.LivreRepository;
import ca.cal.tp1.service.document.CdService;
import ca.cal.tp1.service.document.DvdService;
import ca.cal.tp1.service.document.LivreService;

import java.sql.Date;
import java.time.LocalDate;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {
        // Votre script qui utilise votre API ici
        TcpServer.startTcpServer();


        LivreService livreService = new LivreService(new LivreRepository());
        CdService cdService = new CdService(new CdRepository());
        DvdService dvdService = new DvdService(new DvdRepository());

        LocalDate jour = LocalDate.of(2020, 1, 1);

        livreService.ajouteLivre(1,"titre", jour,1,"ISBN","auteur","editeur",1);
        System.out.println(livreService.getLivre(1));

        cdService.ajouteCd(1,"titre",jour,1,"artiste",1, "genre");
        System.out.println(cdService.getCd(1));

        dvdService.ajouteDvd(1,"titre",jour,1,"directeur", 1, "genre");
        System.out.println(dvdService.getDvd(1));

        Thread.currentThread().join();
    }
}
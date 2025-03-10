package ca.cal.tp2;

import ca.cal.tp2.exception.DataErrorHandler;
import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.repository.DocumentRepositoryJPA;
import ca.cal.tp2.repository.EmpruntRepositoryJPA;
import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.service.BibliothequeSystemService;
import ca.cal.tp2.service.PreposeService;
import ca.cal.tp2.service.dto.DocumentDTO;
import ca.cal.tp2.utils.TcpServer;

import javax.print.Doc;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException, DuplicateEntityException {
        TcpServer.startTcpServer();

        final PreposeService preposeService = new PreposeService(new DocumentRepositoryJPA(), new EmpruntRepositoryJPA(),new EmprunteurRepositoryJPA());
        final BibliothequeSystemService bibliothequeSystemService = new BibliothequeSystemService(new DocumentRepositoryJPA(), new EmprunteurRepositoryJPA());

        try {
            preposeService.ajouteLivre("Harry Potter 3", "JK Rowling", 1998, 4, "2325ER3", "Google", 340);
            DocumentDTO livre1 = bibliothequeSystemService.rechercherDocument("Harry Potter 3", "JK Rowling", null,null,null);
            System.out.println(livre1);

            preposeService.ajouteCD("Billy Jean", "Michael Jackson", 1985, 4, "Michael Jackson", 90, "Pop");
            DocumentDTO cd1 = bibliothequeSystemService.rechercherDocument("Billy Jean", null ,1985,"Michael Jackson",null);
            System.out.println(cd1);

            preposeService.ajouteDVD("Jaws","John Smith",1974,2,"Ellen Mark",150,"Classic");
            DocumentDTO dvd1 = bibliothequeSystemService.rechercherDocument("Jaws",null,1974,null,"Ellen Mark");

            preposeService.ajouteEmprunteur("Leung","Alrik","alrikleung12@hotmail.com","5146598132");


        } catch (DuplicateEntityException e) {
            System.out.println(e.getMessage());
        } catch (DataErrorHandler e) {
            System.out.println("Erreur de recherche : " + e.getMessage());
        }
    }
}

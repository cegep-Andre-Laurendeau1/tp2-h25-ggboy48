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

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException, DuplicateEntityException {
        TcpServer.startTcpServer();

        final PreposeService preposeService = new PreposeService(new DocumentRepositoryJPA(),new EmpruntRepositoryJPA());
        final BibliothequeSystemService bibliothequeSystemService = new BibliothequeSystemService(new DocumentRepositoryJPA(),new EmprunteurRepositoryJPA());


        try{
            preposeService.ajouteLivre("Harry Potter","JK Rowling",1998,4,"2325ER3","Google",340);

            System.out.println("Recherche de livres par titre:");
            DocumentDTO documentDTO1 = bibliothequeSystemService.rechercherDocument("Harry Potter", null, null);
            System.out.println(documentDTO1);

            preposeService.ajouteCD("Billy Jean","Michael Jackson",1985,4,"Michael Jackson",90,"Pop");

        }catch (DuplicateEntityException e){
            System.out.println(e.getMessage());
        } catch (DataErrorHandler e) {
            throw new RuntimeException(e);
        }
    }
}

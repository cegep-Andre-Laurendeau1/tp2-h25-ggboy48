package ca.cal.tp2;

import ca.cal.tp2.exception.DataErrorHandler;
import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.*;
import ca.cal.tp2.repository.DocumentRepositoryJPA;
import ca.cal.tp2.repository.EmpruntRepositoryJPA;
import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.service.BibliothequeSystemService;
import ca.cal.tp2.service.PreposeService;
import ca.cal.tp2.service.dto.DocumentDTO;
import ca.cal.tp2.service.dto.EmprunteurDTO;
import ca.cal.tp2.service.dto.UtilisateurDTO;
import ca.cal.tp2.utils.TcpServer;

import javax.print.Doc;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException, DuplicateEntityException {
        TcpServer.startTcpServer();

        final PreposeService preposeService = new PreposeService(new DocumentRepositoryJPA(), new EmpruntRepositoryJPA(),new EmprunteurRepositoryJPA());
        final BibliothequeSystemService bibliothequeSystemService = new BibliothequeSystemService(new DocumentRepositoryJPA(), new EmprunteurRepositoryJPA(),new EmpruntRepositoryJPA());

        try {

            //Ajouter un livre
            preposeService.ajouteLivre("Harry Potter 3", "JK Rowling", 1998, 4, "2325ER3", "Google", 340);
            DocumentDTO livre1 = bibliothequeSystemService.rechercherDocument("Harry", "JK Rowling", null,null,null);
            System.out.println(livre1);

            //Ajouter un CD
            preposeService.ajouteCD("Billy Jean", "Michael Jackson", 1985, 4, "Michael Jackson", 90, "Pop");
            DocumentDTO cd1 = bibliothequeSystemService.rechercherDocument("Billy", null ,1985,"Michael Jackson",null);
            System.out.println(cd1);

            //Ajouter un DVD
            preposeService.ajouteDVD("Jaws","John Smith",1974,2,"Ellen Mark",150,"Classic");
            DocumentDTO dvd1 = bibliothequeSystemService.rechercherDocument("Jaws",null,1974,null,"Ellen Mark");

            //Ajouter un utilisateur
            preposeService.ajouteEmprunteur("Leung","Alrik","alrikleung12@hotmail.com","5146598132");
            UtilisateurDTO utilisateurDTO = bibliothequeSystemService.rechercheEmprunteur("Leung","Alrik","alrikleung12@hotmail.com");
            System.out.println(utilisateurDTO);

            // Emprunter des documents en utilisant le service
            Emprunteur emprunteur = new Emprunteur(1, "Leung", "Alrik", "alrikleung12@hotmail.com","5146598132"); // Récupération de l'emprunteur
            List<Document> documents = List.of(
                    new Livre(1, "Harry Potter 3", "JK Rowling", 1998, 4, "2325ER3", "Google", 340),  // Utiliser Livre au lieu de Document
                    new CD(2, "Billy Jean", "Michael Jackson", 1985, 4, "Michael Jackson", 90, "Pop")  // Utiliser CD au lieu de Document
            );

            // Utilisation du service pour emprunter des documents
            bibliothequeSystemService.emprunterDocuments("Leung", "Alrik", "alrikleung12@hotmail.com", documents);

            System.out.println("Emprunt réalisé pour l'emprunteur " + emprunteur.getNom() + " " + emprunteur.getPrenom() + " :");
            for (Document document : documents) {
                System.out.println("Document emprunté : " + document.getTitre());
            }


        } catch (DuplicateEntityException e) {
            System.out.println(e.getMessage());
        } catch (DataErrorHandler e) {
            System.out.println("Erreur de recherche : " + e.getMessage());
        }
    }
}

package ca.cal.tp1.service;

import ca.cal.tp1.DTO.CdDTO;
import ca.cal.tp1.DTO.DvdDTO;
import ca.cal.tp1.DTO.LivreDTO;
import ca.cal.tp1.modele.*;
import ca.cal.tp1.persistance.DocumentRepositoryJPA;
import ca.cal.tp1.persistance.InterfaceRepository;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprunteurService {

    private InterfaceRepository<Emprunteur> emprunteurRepository;
    private InterfaceRepository<Document> documentRepository;

    public EmprunteurService( InterfaceRepository<Emprunteur> emprunteurRepository, InterfaceRepository<Document> documentRepository) {
        this.emprunteurRepository = emprunteurRepository;
        this.documentRepository = documentRepository;
    }

    public Document getDocument(Long id){
        return documentRepository.get(id);
    }

    public void saveLivre(String titre, LocalDate anneePublication, int nombreExemplaire, String ISBN, String auteur, String editeur, int nombrePages) {
        documentRepository.save(new Livre(titre, anneePublication, nombreExemplaire, ISBN, auteur, editeur, nombrePages));
    }
    public void saveDvd(String titre, LocalDate anneePublication, int nombreExemplaire, String directeur, int duree, String genre) {
        documentRepository.save(new Dvd(titre, anneePublication, nombreExemplaire, directeur, duree, genre));
    }
    public void saveCd(String titre, LocalDate anneePublication, int nombreExemplaire, String artiste, int duree, String genre) {
        documentRepository.save(new Cd(titre, anneePublication, nombreExemplaire, artiste, duree, genre));
    }


    public void ajouterEmprunteur(String nom, String email, String numTelephone) {
        emprunteurRepository.save(new Emprunteur(nom, email, numTelephone));
    }

    public void saveExemplaire(int nmbreExemplaire, Long idDocument){
        Document document = documentRepository.get(idDocument);
        document.setNombreExemplaire(nmbreExemplaire);
        documentRepository.save(document);
    }
    public void rechercheDocument(String titreSubString, LocalDate anneePublication) {
        List<Document> documents = documentRepository.get(titreSubString, anneePublication);
        System.out.println("\n \n");
        for (Document document : documents) {
            System.out.println(document);
        }
        System.out.println("\n \n");
    }
    public void rechercheDocument(String titreSubString) {
        List<Document> documents = documentRepository.get(titreSubString);
        System.out.println("\n \n");
        for (Document document : documents) {
            System.out.println(document);
        }
        System.out.println("\n \n");
    }
    public void rechercheDocument(LocalDate anneePublication) {
        List<Document> documents = documentRepository.get(anneePublication);
        System.out.println("\n \n");
        for (Document document : documents) {
            System.out.println(document);
        }
        System.out.println("\n \n");
    }

    public void emprunterLivre() {
        // TODO rappelle que s'il n'y a plus d'exemplaire, on ne peut pas emprunter
    }
    public void emprunterCd() {
        // TODO rappelle que s'il n'y a plus d'exemplaire, on ne peut pas emprunter
    }
    public void emprunterDvd() {
        // TODO rappelle que s'il n'y a plus d'exemplaire, on ne peut pas emprunter
    }
    public void getDocumentsEmprunteur(long id){
        // TODO pense a ce que tu doit faire
    }

    public List<EmpruntDetails> getItems(){
        List<EmpruntDetails> emprunts = new ArrayList<>();
        return emprunts;
    }
//    public boolean isEnRetard(Long id) {
//        if (dateRetourActuelle != null) return dateRetourPrevue.isAfter(dateRetourActuelle);
//        LocalDate dateAujourdhui = LocalDate.now();
//        return dateRetourPrevue.isAfter(dateAujourdhui);
//    }
}
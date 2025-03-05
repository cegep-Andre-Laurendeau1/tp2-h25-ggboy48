package ca.cal.tp1.service;

import ca.cal.tp1.DTO.CdDTO;
import ca.cal.tp1.DTO.DvdDTO;
import ca.cal.tp1.DTO.LivreDTO;
import ca.cal.tp1.modele.*;
import ca.cal.tp1.persistance.InterfaceRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprunteurService {
    private InterfaceRepository<Cd> cdRepository;
    private InterfaceRepository<Dvd> dvdRepository;
    private InterfaceRepository<Livre> livreRepository;
    private InterfaceRepository<Emprunteur> emprunteurRepository;

    public EmprunteurService(InterfaceRepository<Cd> cdRepository, InterfaceRepository<Dvd> dvdRepository, InterfaceRepository<Livre> livreRepository, InterfaceRepository<Emprunteur> emprunteurRepository) {
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
        this.livreRepository = livreRepository;
        this.emprunteurRepository = emprunteurRepository;
    }

    public Livre getLivre(Long id) {
        return livreRepository.get(id);
    }
    public Dvd getDvd(Long id) {
        return dvdRepository.get(id);
    }
    public Cd getCd(Long id) {
        return cdRepository.get(id);
    }

    public void saveLivre(String titre, LocalDate anneePublication, int nombreExemplaire, String ISBN, String auteur, String editeur, int nombrePages) {
        livreRepository.save(new Livre(titre, anneePublication, nombreExemplaire, ISBN, auteur, editeur, nombrePages));
    }
    public void saveDvd(String titre, LocalDate anneePublication, int nombreExemplaire, String directeur, int duree, String genre) {
        dvdRepository.save(new Dvd(titre, anneePublication, nombreExemplaire, directeur, duree, genre));
    }
    public void saveCd(String titre, LocalDate anneePublication, int nombreExemplaire, String artiste, int duree, String genre) {
        cdRepository.save(new Cd(titre, anneePublication, nombreExemplaire, artiste, duree, genre));
    }


    public void ajouterEmprunteur(String nom, String email, String numTelephone) {
        emprunteurRepository.save(new Emprunteur(nom, email, numTelephone));
    }
    public void saveExemplaire(int nmbreExemplaire, Long idDocument){

    }
    public void rechercheLivre() {
        // TODO rappelle que le titre ne doit pas être exacte
    }
    public void rechercheCd() {
        // TODO rappelle que le titre ne doit pas être exacte
    }
    public void rechercheDvd() {
        // TODO rappelle que le titre ne doit pas être exacte
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
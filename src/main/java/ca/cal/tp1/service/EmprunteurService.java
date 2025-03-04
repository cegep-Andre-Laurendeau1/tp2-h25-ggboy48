package ca.cal.tp1.service;

import ca.cal.tp1.DTO.CdDTO;
import ca.cal.tp1.DTO.DvdDTO;
import ca.cal.tp1.DTO.LivreDTO;
import ca.cal.tp1.modele.Cd;
import ca.cal.tp1.modele.Dvd;
import ca.cal.tp1.modele.Livre;
import ca.cal.tp1.persistance.InterfaceRepository;

import java.time.LocalDate;

public class EmprunteurService {
    private InterfaceRepository<Cd> cdRepository;
    private InterfaceRepository<Dvd> dvdRepository;
    private InterfaceRepository<Livre> livreRepository;

    public EmprunteurService(InterfaceRepository<Cd> cdRepository, InterfaceRepository<Dvd> dvdRepository, InterfaceRepository<Livre> livreRepository) {
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
        this.livreRepository = livreRepository;
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

    //TODO fait une recherche à partire de l'id et s'il n'existe pas, ajoute le courant, sinon s'il y en a un alors on ajoute le nombre d'exemplaire a l'exemplaire de la bd
    public void saveLivre(String titre, LocalDate anneePublication, int nombreExemplaire, String ISBN, String auteur, String editeur, int nombrePages) {
        livreRepository.save(new Livre(titre, anneePublication, nombreExemplaire, ISBN, auteur, editeur, nombrePages));
        //TODO recherche de l'id dans la base de donnée pour ne pas avoir de doublon et s'il y en a de ajouter le nombre d'exemplaire au exemplaire de la bd
    }
    public void saveDvd(String titre, LocalDate anneePublication, int nombreExemplaire, String directeur, int duree, String genre) {
        dvdRepository.save(new Dvd(titre, anneePublication, nombreExemplaire, directeur, duree, genre));
        //TODO recherche de l'id dans la base de donnée pour ne pas avoir de doublon et s'il y en a de ajouter le nombre d'exemplaire au exemplaire de la bd
    }
    public void saveCd(String titre, LocalDate anneePublication, int nombreExemplaire, String artiste, int duree, String genre) {
        cdRepository.save(new Cd(titre, anneePublication, nombreExemplaire, artiste, duree, genre));
        //TODO recherche de l'id dans la base de donnée pour ne pas avoir de doublon et s'il y en a de ajouter le nombre d'exemplaire au exemplaire de la bd
    }


    public void ajouterClient() {
        // TODO
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

}
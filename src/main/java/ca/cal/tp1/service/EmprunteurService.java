package ca.cal.tp1.service;

import ca.cal.tp1.DTO.CdDTO;
import ca.cal.tp1.DTO.DocumentDTO;
import ca.cal.tp1.DTO.DvdDTO;
import ca.cal.tp1.DTO.LivreDTO;
import ca.cal.tp1.persistance.InterfaceRepository;

import java.time.LocalDate;
import java.util.List;

public class EmprunteurService {
    private InterfaceRepository<CdDTO> cdRepository;
    private InterfaceRepository<DvdDTO> dvdRepository;
    private InterfaceRepository<LivreDTO> livreRepository;

    public EmprunteurService(InterfaceRepository<CdDTO> cdRepository, InterfaceRepository<DvdDTO> dvdRepository, InterfaceRepository<LivreDTO> livreRepository) {
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
        this.livreRepository = livreRepository;
    }

    public LivreDTO getLivre(long id) {
        return livreRepository.get(id);
    }
    public DvdDTO getDvd(long id) {
        return dvdRepository.get(id);
    }
    public CdDTO getCd(long id) {
        return cdRepository.get(id);
    }

    //TODO fait une recherche à partire de l'id et s'il n'existe pas, ajoute le courant, sinon s'il y en a un alors on ajoute le nombre d'exemplaire a l'exemplaire de la bd
    public void saveLivre(int id, String titre, LocalDate anneePublication, int nombreExemplaire, String ISBN, String auteur, String editeur, int nombrePages) {
        livreRepository.save(new LivreDTO(id, titre, anneePublication, nombreExemplaire, ISBN, auteur, editeur, nombrePages));
        //TODO recherche de l'id dans la base de donnée pour ne pas avoir de doublon et s'il y en a de ajouter le nombre d'exemplaire au exemplaire de la bd
    }
    public void saveDvd(int id, String titre, LocalDate anneePublication, int nombreExemplaire, String directeur, int duree, String genre) {
        dvdRepository.save(new DvdDTO(id, titre, anneePublication, nombreExemplaire, directeur, duree, genre));
        //TODO recherche de l'id dans la base de donnée pour ne pas avoir de doublon et s'il y en a de ajouter le nombre d'exemplaire au exemplaire de la bd
    }
    public void saveCd(int id, String titre, LocalDate anneePublication, int nombreExemplaire, String artiste, int duree, String genre) {
        cdRepository.save(new CdDTO(id, titre, anneePublication, nombreExemplaire, artiste, duree, genre));
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
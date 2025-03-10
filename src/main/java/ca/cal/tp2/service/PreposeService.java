package ca.cal.tp2.service;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.*;


public class PreposeService {
    private final DocumentRepositoryJPA documentRepository;
    private final EmpruntRepositoryJPA empruntRepository;

    public PreposeService(DocumentRepositoryJPA documentRepository, EmpruntRepositoryJPA empruntRepository) {
        this.documentRepository = documentRepository;
        this.empruntRepository = empruntRepository;
    }

    public void ajouteLivre(String titre, String auteur, int anneePublication, int nbrInventaire,String isbn, String editeur, int nbPages) throws DuplicateEntityException {
        Livre livre =new Livre(null,titre,auteur,anneePublication,nbrInventaire,isbn,editeur,nbPages);
        documentRepository.save(livre);
        System.out.println("Livre est bien enregistrer!");
    }

    public void ajouteCD(String titre, String auteur, int anneePublication, int nbrInventaire, String artiste, int duree, String genre ) throws DuplicateEntityException {
        CD cd  = new CD(null,titre,auteur,anneePublication,nbrInventaire,artiste,duree,genre);
        documentRepository.save(cd);
        System.out.println("CD est bien enregistrer");
    }

    public void ajouteDVD(String titre, String auteur, int anneePublication, int nbrInventaire, String directeur, int duree, String rating) throws DuplicateEntityException {
        DVD dvd = new DVD(null,titre,auteur,anneePublication,nbrInventaire,directeur,duree,rating);
        documentRepository.save(dvd);
        System.out.println("DVD est bien enregistrer");
    }


}

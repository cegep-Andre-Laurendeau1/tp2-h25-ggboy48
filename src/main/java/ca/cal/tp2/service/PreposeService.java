package ca.cal.tp2.service;

import ca.cal.tp2.exception.DataErrorHandler;
import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.*;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

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
        System.out.println("Livre inséré avec succès !");
    }

    public void ajouteCD(String titre, String auteur, int anneePublication, int nbrInventaire, String artiste, int duree, String genre ) throws DuplicateEntityException {
        CD cd  = new CD(null,titre,auteur,anneePublication,nbrInventaire,artiste,duree,genre);
        documentRepository.save(cd);
        System.out.println("CD est bien enregistrer");
    }


}

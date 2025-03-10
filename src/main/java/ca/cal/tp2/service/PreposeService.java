package ca.cal.tp2.service;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.CDRepository;
import ca.cal.tp2.repository.DVDRepository;
import ca.cal.tp2.repository.DocumentRepository;
import ca.cal.tp2.repository.LivreRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class PreposeService {
    private final LivreService livreService;
    private final CDService cdService;
    private final LivreRepository livreRepository;
    private final CDRepository cdRepository;
    private final DVDRepository dvdRepository;
    private final DocumentRepository documentRepository;

    public PreposeService(LivreService livreService, CDService cdService, LivreRepository livreRepository, CDRepository cdRepository, DVDRepository dvdRepository, DocumentRepository documentRepository) {
        this.livreService = livreService;
        this.cdService = cdService;
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
        this.documentRepository = documentRepository;
    }

    public void ajouterLivre(int id, String titre, String auteur, int anneePublication, int dureEmprunt, int nbInventaire ,String isbn, String editeur, int nbPages) throws DuplicateEntityException {
        livreService.createLivre(id,titre,auteur,anneePublication,dureEmprunt,nbInventaire,isbn,editeur,nbPages);
    }


    public Livre getLivreById(int id) throws EntityNotFoundException {
        return livreService.findLivre(id);
    }


    public void ajouterCD(int id, String titre, String auteur, int anneePublication, int dureEmprunt, int nbInventaire, String artiste, int duree, String genre) {
        CD cd = new CD(id,titre,auteur,anneePublication,dureEmprunt,nbInventaire,artiste,duree,genre);
        documentRepository.saveDocument(cd);
    }

    public CD getCDById(int id) {
        return cdService.findCD(id);
    }

    public void ajouterDVD(int id, String titre, String auteur, int anneePublication, int dureEmprunt, int nbInventaire, String directeur ,int duree, String rating){
        DVD dvd = new DVD(id,titre,auteur,anneePublication,dureEmprunt,nbInventaire,directeur,duree,rating);
        documentRepository.saveDocument(dvd);
    }

    public DVD getDVDById(int id) {
        return dvdRepository.getDvDById(id);
    }

}

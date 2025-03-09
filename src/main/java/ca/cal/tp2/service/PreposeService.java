package ca.cal.tp2.service;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.CDRepository;
import ca.cal.tp2.repository.DVDRepository;
import ca.cal.tp2.repository.DocumentRepository;
import ca.cal.tp2.repository.LivreRepository;

import java.util.List;

public class PreposeService {
    private final LivreRepository livreRepository;
    private final CDRepository cdRepository;
    private final DVDRepository dvdRepository;
    private final DocumentRepository documentRepository;

    public PreposeService(LivreRepository livreRepository, CDRepository cdRepository, DVDRepository dvdRepository, DocumentRepository documentRepository) {
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
        this.documentRepository = documentRepository;
    }

    public void ajouterLivre(int id, String titre, String auteur, int anneePublication, int dureEmprunt, int nbInventaire ,String isbn, String editeur, int nbPages) {
        Livre livre = new Livre(id, titre, auteur, anneePublication, dureEmprunt, nbInventaire, isbn, editeur, nbPages);
        livreRepository.save(livre);

    }

    public Livre getLivreById(int id) {
        return livreRepository.findById(id).orElse(null);
    }


    public void ajouterCD(int id, String titre, String auteur, int anneePublication, int dureEmprunt, int nbInventaire, String artiste, int duree, String genre) {
        CD cd = new CD(id,titre,auteur,anneePublication,dureEmprunt,nbInventaire,artiste,duree,genre);
        documentRepository.saveDocument(cd);
    }

    public CD getCDById(int id) {
        return cdRepository.getCDById(id);
    }

    public void ajouterDVD(int id, String titre, String auteur, int anneePublication, int dureEmprunt, int nbInventaire, String directeur ,int duree, String rating){
        DVD dvd = new DVD(id,titre,auteur,anneePublication,dureEmprunt,nbInventaire,directeur,duree,rating);
        documentRepository.saveDocument(dvd);
    }

    public DVD getDVDById(int id) {
        return dvdRepository.getDvDById(id);
    }

}

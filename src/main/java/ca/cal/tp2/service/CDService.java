package ca.cal.tp2.service;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.repository.CDRepository;

public class CDService {
    private final CDRepository cdRepository;

    public CDService(CDRepository cdRepository) {
        this.cdRepository = cdRepository;
    }

    public void createCD(int id, String titre, String auteur, int anneePublication, int dureEmprunt, int nbInventaire ,String artiste,int duree, String genre) throws DuplicateEntityException {
        CD cd = new CD(id,titre,auteur,anneePublication,dureEmprunt,nbInventaire,artiste,duree,genre);
        cdRepository.save(cd);
    }

    public CD findCD(int id) {
        return cdRepository.find(id);
    }
    


}

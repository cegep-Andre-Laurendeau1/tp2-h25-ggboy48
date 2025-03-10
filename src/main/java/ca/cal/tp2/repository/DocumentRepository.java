package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;



public interface DocumentRepository {
    void save(Document document) throws DuplicateEntityException;
    Livre rechercheLivre(String titre, String auteur, Integer anneePublication) throws DuplicateEntityException;
    CD rechercheCD(String titre, String artiste) throws DuplicateEntityException;
    DVD rechercheDVD(String titre, String directeur) throws DuplicateEntityException;
}






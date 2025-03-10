package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DataErrorHandler;
import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityNotFoundException;


public interface DocumentRepository {
    void save(Document document) throws DuplicateEntityException;
    Livre rechercheLivre(String titre, String auteur, Integer annee) throws DataErrorHandler;
    CD rechercheCd(String titre, String artiste) throws DataErrorHandler;
    DVD rechercheDvd(String titre, String directeur) throws DataErrorHandler;
}






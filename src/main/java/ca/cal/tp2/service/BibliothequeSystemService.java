package ca.cal.tp2.service;

import ca.cal.tp2.exception.DataErrorHandler;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.repository.DocumentRepositoryJPA;
import ca.cal.tp2.repository.EmpruntRepository;
import ca.cal.tp2.repository.EmpruntRepositoryJPA;
import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.service.dto.DocumentDTO;

public class BibliothequeSystemService {
    private final DocumentRepositoryJPA documentRepository;
    private final EmprunteurRepositoryJPA emprunteurRepository;

    public BibliothequeSystemService(DocumentRepositoryJPA documentRepository, EmprunteurRepositoryJPA empruntRepository) {
        this.documentRepository = documentRepository;
        this.emprunteurRepository= empruntRepository;
    }

    public Document getDocument(String titre, String auteur, Integer anneePublication) throws DataErrorHandler{
        Document document = documentRepository.rechercheLivre(titre, auteur, anneePublication);
        if (document == null) {
            document = documentRepository.rechercheCd(titre, auteur);
        }
        if (document == null) {
            document = documentRepository.rechercheDvd(titre, auteur);
        }

        return document;
    }

    public DocumentDTO rechercherDocument(String titre, String auteur, Integer anneePublication) throws DataErrorHandler{
        Document document = getDocument(titre, auteur, anneePublication);
        return DocumentDTO.toDto(document);
    }

}



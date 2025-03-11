package ca.cal.tp2.service;

import ca.cal.tp2.exception.DataErrorHandler;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Utilisateur;
import ca.cal.tp2.repository.DocumentRepositoryJPA;
import ca.cal.tp2.repository.EmpruntRepository;
import ca.cal.tp2.repository.EmpruntRepositoryJPA;
import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.service.dto.DocumentDTO;
import ca.cal.tp2.service.dto.UtilisateurDTO;

public class BibliothequeSystemService {
    private final DocumentRepositoryJPA documentRepository;
    private final EmprunteurRepositoryJPA emprunteurRepository;

    public BibliothequeSystemService(DocumentRepositoryJPA documentRepository, EmprunteurRepositoryJPA empruntRepository) {
        this.documentRepository = documentRepository;
        this.emprunteurRepository= empruntRepository;
    }

    public Document getDocument(String titre, String auteur, Integer anneePublication, String artiste, String directeur) throws DataErrorHandler {
        Document document = documentRepository.rechercheLivre(titre, auteur, anneePublication);
        if (document != null) {
            System.out.println("Livre trouvé : " + document);
        } else {
            System.out.println("Aucun livre trouvé, recherche CD...");
        }

        if (document == null) {
            document = documentRepository.rechercheCd(titre, artiste);
            if (document != null) {
                System.out.println("CD trouvé : " + document);
            } else {
                System.out.println("Aucun CD trouvé, recherche DVD...");
            }
        }

        if (document == null) {
            document = documentRepository.rechercheDvd(titre, directeur);
            if (document != null) {
                System.out.println("DVD trouvé : " + document);
            }
        }

        return document;
    }


    public DocumentDTO rechercherDocument(String titre, String auteur, Integer anneePublication,String artiste, String directeur) throws DataErrorHandler{
        Document document = getDocument(titre, auteur, anneePublication,artiste,directeur);
        if(document == null) {
            throw new DataErrorHandler("Erreur, on trouve pas");
        }
        return DocumentDTO.toDto(document);
    }



    public UtilisateurDTO rechercheEmprunteur(String nom ,String prenom, String email) throws DataErrorHandler {
        Utilisateur emprunteur = getEmprunteur(nom,prenom,email);
        if(emprunteur == null) {
            throw new DataErrorHandler("Erreur, on trouve pas");
        }
        return UtilisateurDTO.toDto(emprunteur);
    }

    public Emprunteur getEmprunteur(String nom, String prenom, String email) throws DataErrorHandler {
        return emprunteurRepository.getByNomPrenomEmail(nom, prenom, email);
    }



}



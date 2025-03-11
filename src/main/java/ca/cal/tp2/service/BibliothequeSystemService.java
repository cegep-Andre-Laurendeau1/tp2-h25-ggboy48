package ca.cal.tp2.service;

import ca.cal.tp2.exception.DataErrorHandler;
import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.*;
import ca.cal.tp2.repository.DocumentRepositoryJPA;
import ca.cal.tp2.repository.EmpruntRepository;
import ca.cal.tp2.repository.EmpruntRepositoryJPA;
import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.service.dto.DocumentDTO;
import ca.cal.tp2.service.dto.UtilisateurDTO;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;


public class BibliothequeSystemService {
    private final DocumentRepositoryJPA documentRepository;
    private final EmprunteurRepositoryJPA emprunteurRepository;
    private final EmpruntRepositoryJPA empruntRepository;

    public BibliothequeSystemService(DocumentRepositoryJPA documentRepository, EmprunteurRepositoryJPA emprunteurRepositoryJPA, EmpruntRepositoryJPA empruntRepository) {
        this.documentRepository = documentRepository;
        this.emprunteurRepository= emprunteurRepositoryJPA;
        this.empruntRepository = empruntRepository;
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


    public void emprunterDocuments(String nom, String prenom, String email, List<Document> documents) throws DataErrorHandler {
        try {
            Emprunteur emprunteur = emprunteurRepository.getByNomPrenomEmail(nom, prenom, email);
            if (emprunteur == null) {
                throw new DataErrorHandler("Emprunteur non trouvé !");
            }

            LocalDate dateEmprunt = LocalDate.now();
            Emprunt emprunt = new Emprunt(null, dateEmprunt, emprunteur);

            for (Document document : documents) {
                if (document.getNbrInventaires() <= 0) {
                    throw new DataErrorHandler("Plus de copies disponibles pour le document : " + document.getTitre());
                }

                // Calculer la date de retour prévue
                LocalDate dateRetourPrevue = calculerDateRetour(document, dateEmprunt);
                EmpruntDetail empruntDetail = new EmpruntDetail(null, dateRetourPrevue, null, "En cours", emprunt, document);
                emprunt.getItems(empruntDetail);
            }

            emprunteur.getEmprunts().add(emprunt);
            empruntRepository.save(emprunt);
        } catch (DataErrorHandler e) {
            throw e;
        } catch (DuplicateEntityException e) {
            throw new RuntimeException(e);
        }
    }


    private LocalDate calculerDateRetour(Document document, LocalDate dateEmprunt) {
        LocalDate dateRetourPrevue = dateEmprunt;
        if (document instanceof Livre) {
            dateRetourPrevue = dateEmprunt.plusWeeks(3); // Pour un livre : 3 semaines
        } else if (document instanceof CD) {
            dateRetourPrevue = dateEmprunt.plusWeeks(2); // Pour un CD : 2 semaines
        } else if (document instanceof DVD) {
            dateRetourPrevue = dateEmprunt.plusWeeks(1); // Pour un DVD : 1 semaine
        }
        return dateRetourPrevue;
    }





}



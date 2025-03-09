package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Utilisateur;

import java.util.List;

public interface UtilisateurRepositoryInterface {
    void saveUtilisateur(Utilisateur utilisateur);
    Utilisateur getUtilisateurByID(int userID);
    List<Utilisateur> getAllUtilisateurs();
    void updateUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(int userID);
}

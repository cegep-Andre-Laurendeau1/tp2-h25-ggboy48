package ca.cal.tp2.modele;


import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Livre") // Hibernate va créer une table "Livre"
@Data
@NoArgsConstructor


public class Livre extends Document {

    @Column(nullable = false, unique = true)
    private String ISBN;

    @Column(nullable = false)
    private String editeur;

    @Column(nullable = false)
    private int nbPages;


    public Livre(int id, String titre, String auteur, int anneePublication, int dureeEmprunt, int nbrInventaire,
                 String ISBN, String editeur, int nbPages) {
        super(id, titre, auteur, anneePublication, dureeEmprunt, nbrInventaire);
        this.ISBN = ISBN;
        this.editeur = editeur;
        this.nbPages = nbPages;
    }


    @Override
    public void verifierDisponible() {
        // Logique spécifique pour vérifier si un exemplaire du livre est disponible
        if (this.getNbrInventaires() > 0) {
            System.out.println("Le livre " + this.getTitre() + " est disponible.");
        } else {
            System.out.println("Le livre " + this.getTitre() + " n'est pas disponible.");
        }
    }


    @Override
    public String toString() {
        return "Livre [id=" + getId() + ", titre=" + getTitre() + ", auteur=" + getAuteur() +
                ", anneePublication=" + getAnneePublication() + ", dureeEmprunt=" + getDureeEmprunt() +
                ", nbrInventaires=" + getNbrInventaires() + ", ISBN=" + ISBN +
                ", editeur=" + editeur + ", nbPages=" + nbPages + "]";
    }




}

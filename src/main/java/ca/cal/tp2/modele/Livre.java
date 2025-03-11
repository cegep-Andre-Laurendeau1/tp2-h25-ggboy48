package ca.cal.tp2.modele;


import jakarta.persistence.DiscriminatorValue;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name = "Livre") // Hibernate va créer une table "Livre"
@Data
@NoArgsConstructor
@ToString

public class Livre extends Document {

    private String ISBN;

    private String editeur;

    private int nbPages;

    private int dureeEmprunt = 21;

    @Override
    public int getDureeEmprunt() {
        return dureeEmprunt;
    }


    public Livre(Integer id, String titre, String auteur, int anneePublication, int nbrInventaire,
                 String ISBN, String editeur, int nbPages) {
        super(id, titre, auteur, anneePublication,  nbrInventaire);
        this.ISBN = ISBN;
        this.editeur = editeur;
        this.nbPages = nbPages;
    }









}

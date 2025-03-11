package ca.cal.tp2.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name="Document")
@DiscriminatorColumn(name = "type_document", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor

public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String auteur;
    private int anneePublication;
    private int nbrInventaires;

    public abstract int getDureeEmprunt();

    public Document(Integer id, String titre, String auteur, int anneePublication, int nbrInventaires) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.nbrInventaires = nbrInventaires;
    }


}

package ca.cal.tp2.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_document", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor

public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String auteur;
    private int anneePublication;
    private int dureeEmprunt;
    private int nbrInventaires;

    public Document(int id, String titre, String auteur, int anneePublication, int dureeEmprunt, int nbrInventaires) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.dureeEmprunt = dureeEmprunt;
        this.nbrInventaires = nbrInventaires;
    }

    public void verifierDisponible() {
        System.out.println("La disponibilité du document est vérifiée.");
    }

    @Override
    public String toString() {
        return "Document [id=" + id + ", titre=" + titre + ", auteur=" + auteur +
                ", anneePublication=" + anneePublication + ", dureeEmprunt=" + dureeEmprunt +
                ", nbrInventaires=" + nbrInventaires + "]";
    }
}

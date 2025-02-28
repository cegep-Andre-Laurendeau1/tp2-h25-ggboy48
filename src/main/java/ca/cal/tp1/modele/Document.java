package ca.cal.tp1.modele;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public abstract class Document {
    private long documentID;
    private String titre;
    private LocalDate anneePublication;
    private int nombreExemplaire;
    public Document(long id, String titre, LocalDate anneePublication, int nombreExemplaire){
        this.documentID = id;
        this.titre = titre;
        this.anneePublication = anneePublication;
        this.nombreExemplaire = nombreExemplaire;
    }
    public long getId() {
        return documentID;
    }

    public String getTitre() {
        return titre;
    }

    public LocalDate getAnneePublication() {
        return anneePublication;
    }

    public int getNombreExemplaire() {
        return nombreExemplaire;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentID=" + documentID +
                ", titre='" + titre + '\'' +
                ", anneePublication=" + anneePublication +
                ", nombreExemplaire=" + nombreExemplaire +
                '}';
    }
}
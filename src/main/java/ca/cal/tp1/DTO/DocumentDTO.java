package ca.cal.tp1.DTO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


public abstract class DocumentDTO {
    private long documentID;
    private String titre;
    private LocalDate anneePublication;
    private int nombreExemplaire;
    public DocumentDTO(long id, String titre, LocalDate anneePublication, int nombreExemplaire){
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

    public void setDocumentID(long documentID) {
        this.documentID = documentID;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAnneePublication(LocalDate anneePublication) {
        this.anneePublication = anneePublication;
    }

    public void setNombreExemplaire(int nombreExemplaire) {
        this.nombreExemplaire = nombreExemplaire;
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
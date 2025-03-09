package ca.cal.tp2.modele;

import lombok.Data;

import java.util.Date;

@Data
public class EmpruntDocument {
    private int idEmpruntDocument;
    private Date dateRetourPrevue;
    private Date dateRetourActuelle;
    private String status;
    private Document document;

    //methode
    public void isEnRetard(){}
    public void calculAmende(){}
    public void updateStatus(){}
}

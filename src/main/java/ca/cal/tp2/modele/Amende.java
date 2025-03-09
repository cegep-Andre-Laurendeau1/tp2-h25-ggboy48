package ca.cal.tp2.modele;

import lombok.Data;

import java.util.Date;

@Data
public class Amende {
    private int idAmende;
    private double montant;
    private Date dateCreation;
    private boolean status;

    public Amende(int idAmende, double montant, Date dateCreation, boolean status) {
        this.idAmende = idAmende;
        this.montant = montant;
        this.dateCreation = dateCreation;
        this.status = status;
    }

    //methode
    public void calculerMontant() {}
    public void updateStatus(){}


}


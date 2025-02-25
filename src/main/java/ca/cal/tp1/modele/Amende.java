package ca.cal.tp1.modele;

import java.sql.Date;

public class Amende {
    private int fineID;
    private double montant = 0.0;
    private Date dateCreation;
    private boolean status;
    public double calculMontant(double valeur) {
        return montant + valeur;
    }
        public void updateStatus(boolean status){
            this.status = status;
        }
}
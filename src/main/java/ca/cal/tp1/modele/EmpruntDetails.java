package ca.cal.tp1.modele;

import java.sql.Date;
import java.time.LocalDate;

public class EmpruntDetails {
    private int lineItemID;
    private Date dateRetourPrevue;
    private Date dateRetourActuelle;
    private String status;

    public EmpruntDetails(int lineItemID, Date dateRetourPrevue, Date dateRetourActuelle, String status) {
        this.lineItemID = lineItemID;
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourActuelle = dateRetourActuelle;
        this.status = status;
    }
    public EmpruntDetails(int lineItemID, Date dateRetourPrevue, String status) {
        this.lineItemID = lineItemID;
        this.dateRetourPrevue = dateRetourPrevue;
        this.status = status;
    }
    public boolean isEnRetard(){
        if(dateRetourActuelle != null) return dateRetourPrevue.getTime()>dateRetourActuelle.getTime();
        LocalDate dateAujourdhui = LocalDate.now();
        Date dateAujourdhuiSQL = Date.valueOf(dateAujourdhui);
        return dateRetourPrevue.getTime() > dateAujourdhuiSQL.getTime();
    }

    public int getLineItemID() {
        return lineItemID;
    }

    public Date getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public Date getDateRetourActuelle() {
        return dateRetourActuelle;
    }

    public String getStatus() {
        return status;
    }
}

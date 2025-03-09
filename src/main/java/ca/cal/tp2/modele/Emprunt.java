package ca.cal.tp2.modele;

import lombok.Data;

import java.util.Date;

@Data
public class Emprunt {
    private int idEmprunt;
    private Date dateEmprunt;
    private String statusEmprunt;
    private EmpruntDocument emprunt;

    //methode
    public void getItems(){}
}

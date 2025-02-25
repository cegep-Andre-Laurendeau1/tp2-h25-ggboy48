package ca.cal.tp1.modele.utilisateur;

import ca.cal.tp1.modele.Amende;
import ca.cal.tp1.modele.document.Document;
import ca.cal.tp1.modele.Emprunt;

import java.util.ArrayList;
import java.util.List;

public class Prepose extends Utilisateur {
    public void entreNouveauDocument(Document document) {

    }
    public void collecteAmende(Emprunteur emprunteur, double payment) {

    }
    public List<Amende> rapportAmendes(){
        List<Amende> amendes = new ArrayList<Amende>();
        return amendes;
    }
    public List<Emprunt> rapportEmprunts(){
        List<Emprunt> emprunt = new ArrayList<>();
        return emprunt;
    }

}

package ca.cal.tp1.modele;

public class Emprunteur extends Utilisateur {
    public void emprunte(Document document) throws Exception {
        if(document.getNombreExemplaire()<0)throw new Exception("Pas assez d'exemplaire.");

    }
}

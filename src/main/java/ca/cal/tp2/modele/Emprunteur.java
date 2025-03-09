package ca.cal.tp2.modele;

public class Emprunteur extends Utilisateur {



    public Emprunteur(int id, String nom, String prnom ,String email ,String phone) {
        super(id, nom, prnom, email, phone);

    }



    //methode
    public void emprunte(Document document){}
    public void retourneDocument(Document document){}
    public void payerAmende(Double amende){}
    public void rapportHistoriqueEmprunt(){}

}

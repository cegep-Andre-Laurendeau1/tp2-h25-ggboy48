package ca.cal.tp2.modele;

public class Prepose extends Utilisateur {
    private String role;


    public Prepose(int id, String nom, String prenom, String email, String phone, String role) {
        super(id, nom, prenom, email, phone);
        this.role = role;

    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    //methode
    public void entreNouveauDocument(Document doc) {}
    public void collectAmendes(Emprunteur emprunteur,double amendes){}
    public void rapportAmendes(){}
    public void rappostEmprunts(){}


}

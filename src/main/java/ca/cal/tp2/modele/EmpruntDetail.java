package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Getter
@Setter
public class EmpruntDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lineItemID;  // Identifiant unique pour chaque détail d'emprunt

    private LocalDate dateRetourPrevue;  // Date prévue pour le retour du document

    private LocalDate dateRetourActuelle;  // Date réelle du retour du document (peut être null si non retourné)

    private String status;  // Statut de l'emprunt (ex: "En cours", "Retardé", "Terminé")

    @ManyToOne
    @JoinColumn(name = "emprunt_id")
    private Emprunt emprunt;  // Référence vers l'emprunt auquel ce détail appartient

    @ManyToOne
    @JoinColumn(name = "id_document")
    private Document document;  // Référence vers le document emprunté (Livre, CD, DVD)


    public EmpruntDetail(Integer lineItemID, LocalDate dateRetourPrevue, LocalDate dateRetourActuelle, String status, Emprunt emprunt, Document document) {
        this.lineItemID = lineItemID;
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourActuelle = dateRetourActuelle;
        this.status = status;
        this.emprunt = emprunt;
        this.document = document;
    }

    // Méthode pour calculer la date de retour prévue
    public void calculDateRetourPrevue() {
        this.dateRetourPrevue = emprunt.getDateEmprunt().plusDays(document.getDureeEmprunt());
    }

    // Méthode pour vérifier si le document est en retard
    public boolean isEnRetard() {
        if (dateRetourActuelle != null && dateRetourActuelle.isAfter(dateRetourPrevue)) {
            return true;
        }
        return false;
    }


    // Methode pour changer le status
    public void updateStatus() {
        if (dateRetourActuelle != null) {
            this.status = "Terminé";
        } else if (isEnRetard()) {
            this.status = "Retardé";
        } else {
            this.status = "En cours";
        }
    }
}

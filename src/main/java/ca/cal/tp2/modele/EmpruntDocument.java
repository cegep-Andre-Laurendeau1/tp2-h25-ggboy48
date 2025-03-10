package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class EmpruntDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmpruntDocument;

    @Setter
    private LocalDate dateRetourPrevue;

    @Setter
    private LocalDate dateRetourActuelle;

    @Setter
    private String status;

    @ManyToOne
    @JoinColumn(name = "emprunt_id")
    private Emprunt emprunt;

    @ManyToOne
    @JoinColumn(name="id_document")
    private Document document;


    public EmpruntDocument(long idEmpruntDocument, LocalDate dateRetourPrevue, LocalDate dateRetourActuelle, String status, Emprunt emprunt, Document document) {
        this.idEmpruntDocument=idEmpruntDocument;
        this.dateRetourPrevue=dateRetourPrevue;
        this.dateRetourActuelle=dateRetourActuelle;
        this.status=status;
        this.emprunt=emprunt;
        this.document=document;

    }

    //methode
    public void isEnRetard(){}
    public void calculAmende(){}
    public void updateStatus(){}
}

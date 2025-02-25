package ca.cal.tp1.service.document;

import ca.cal.tp1.modele.document.Livre;
import ca.cal.tp1.persistance.LivreRepository;
import java.time.LocalDate;

public class LivreService {
    LivreRepository livreRepository;
    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public void ajouteLivre(int id, String titre, LocalDate anneePublication, int nombreExemplaire, String ISBN, String auteur, String editeur, int nombrePages) {
        this.livreRepository.save(new Livre(id, titre,anneePublication,nombreExemplaire, ISBN, auteur, editeur, nombrePages));
    }

    public Livre getLivre(long id) {
        return (Livre) this.livreRepository.get(id);
    }
}

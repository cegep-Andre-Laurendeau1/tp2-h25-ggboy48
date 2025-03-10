package ca.cal.tp2.service;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.LivreRepository;

public class LivreService {
    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public void createLivre(int id, String titre, String auteur, int anneePublication, int dureEmprunt, int nbInventaire ,String isbn, String editeur, int nbPages) throws DuplicateEntityException {
        Livre livre = new Livre(id,titre, auteur, anneePublication, dureEmprunt, nbInventaire, isbn, editeur, nbPages);
        livreRepository.save(livre);
    }

    public Livre findLivre(long id) {
        return livreRepository.find(id);
    }
}

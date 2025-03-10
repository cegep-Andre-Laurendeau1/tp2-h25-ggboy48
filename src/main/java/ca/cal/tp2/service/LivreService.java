package ca.cal.tp2.service;

import ca.cal.tp2.exception.DuplicateEntityException;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.LivreRepository;

public class LivreService {
    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }


}

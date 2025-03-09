package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Livre;

import java.util.List;

public interface LivreRepositoryInterface {
    List<Livre> getAllLivres();
    Livre getLivreById(int id);
}

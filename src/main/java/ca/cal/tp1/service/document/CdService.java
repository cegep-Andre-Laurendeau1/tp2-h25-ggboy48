package ca.cal.tp1.service.document;

import ca.cal.tp1.modele.document.Cd;
import ca.cal.tp1.persistance.CdRepository;
import java.time.LocalDate;

public class CdService {
    CdRepository cdRepository;
    public CdService(CdRepository cdRepository) {
        this.cdRepository = cdRepository;
    }
    public void ajouteCd(long id, String titre, LocalDate anneePublication, int nombreExemplaires, String artiste, int duree, String genre) {
        this.cdRepository.save(new Cd(id, titre, anneePublication, nombreExemplaires, artiste, duree, genre));
    }

    public Cd getCd(long id) {
        return (Cd) this.cdRepository.get(id);
    }
}

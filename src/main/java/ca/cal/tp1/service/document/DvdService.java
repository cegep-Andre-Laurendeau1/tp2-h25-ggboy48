package ca.cal.tp1.service.document;

import ca.cal.tp1.modele.document.Dvd;
import ca.cal.tp1.persistance.DvdRepository;
import java.time.LocalDate;

public class DvdService {
    DvdRepository dvdRepository;
    public DvdService(DvdRepository dvdRepository) {
        this.dvdRepository = dvdRepository;
    }
    public void ajouteDvd(long id, String titre, LocalDate aneePublication, int nombreExemplaire, String directeur, int duree, String genre ) {
        this.dvdRepository.save(new Dvd(id, titre, aneePublication,nombreExemplaire,directeur,duree,genre));
    }
    public Dvd getDvd(long id){
        return (Dvd) this.dvdRepository.get(id);
    }
}

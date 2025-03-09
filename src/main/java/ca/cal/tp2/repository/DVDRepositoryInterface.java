package ca.cal.tp2.repository;


import ca.cal.tp2.modele.DVD;

import java.util.List;

public interface DVDRepositoryInterface {
    List<DVD> getAllDVDs();
    DVD getDvDById(int id);
}

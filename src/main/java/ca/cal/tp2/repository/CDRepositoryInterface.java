package ca.cal.tp2.repository;

import ca.cal.tp2.modele.CD;

import java.util.List;

public interface CDRepositoryInterface {
    List<CD> getAllCDs();
    CD getCDById(int id);
}

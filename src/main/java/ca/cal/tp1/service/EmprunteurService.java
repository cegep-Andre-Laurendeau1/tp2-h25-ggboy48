package ca.cal.tp1.service;

import ca.cal.tp1.DTO.CdDTO;
import ca.cal.tp1.DTO.DocumentDTO;
import ca.cal.tp1.DTO.DvdDTO;
import ca.cal.tp1.DTO.LivreDTO;
import ca.cal.tp1.persistance.InterfaceRepository;

import java.time.LocalDate;
import java.util.List;

public class EmprunteurService {
    private InterfaceRepository<CdDTO> cdRepository;
    private InterfaceRepository<DvdDTO> dvdRepository;
    private InterfaceRepository<LivreDTO> livreRepository;

    public EmprunteurService(InterfaceRepository<CdDTO> cdRepository, InterfaceRepository<DvdDTO> dvdRepository, InterfaceRepository<LivreDTO> livreRepository) {
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
        this.livreRepository = livreRepository;
    }

    public LivreDTO getLivre(long id) {
        return livreRepository.get(id);
    }
    public DvdDTO getDvd(long id) {
        return dvdRepository.get(id);
    }
    public CdDTO getCd(long id) {
        return cdRepository.get(id);
    }
    public void ajouterLivre(int id, String titre, LocalDate anneePublication, int nombreExemplaire, String ISBN, String auteur, String editeur, int nombrePages) {
        livreRepository.save(new LivreDTO(id, titre, anneePublication, nombreExemplaire, ISBN, auteur, editeur, nombrePages));
    }
    public void ajouterDvd(int id, String titre, LocalDate anneePublication, int nombreExemplaire, String directeur, int duree, String genre) {
        dvdRepository.save(new DvdDTO(id, titre, anneePublication, nombreExemplaire, directeur, duree, genre));
    }
    public void ajouterCd(int id, String titre, LocalDate anneePublication, int nombreExemplaire, String artiste, int duree, String genre) {
        cdRepository.save(new CdDTO(id, titre, anneePublication, nombreExemplaire, artiste, duree, genre));
    }
}
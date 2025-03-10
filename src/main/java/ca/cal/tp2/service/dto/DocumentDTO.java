package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class DocumentDTO {
    private Integer id;
    private String titre;
    private String auteur;
    private int anneePublication;
    private int nbrInventaires;

  public static DocumentDTO toDto(Document document) {
      if (document == null) {
          return null;
      }
      if (document instanceof Livre) {
          Livre livre = (Livre) document;
          return new LivreDTO(livre.getId(), livre.getTitre(), livre.getAuteur(),livre.getAnneePublication(),livre.getNbrInventaires(),livre.getISBN(),livre.getEditeur(),livre.getNbPages());
      }
      if (document instanceof CD) {
          CD cd = (CD) document;
          return new CdDTO(cd.getId(),cd.getTitre(), cd.getAuteur(), cd.getAnneePublication(),cd.getNbrInventaires(),cd.getArtiste(),cd.getDuree(),cd.getGenre());

      }
      if (document instanceof DVD) {
            DVD dvd = (DVD) document;
            return new DvdDTO(dvd.getId(), dvd.getTitre(), dvd.getAuteur(), dvd.getAnneePublication(),dvd.getNbrInventaires(),dvd.getDirecteur(),dvd.getDuree(),dvd.getRating());
      }

      return null;
  }


}

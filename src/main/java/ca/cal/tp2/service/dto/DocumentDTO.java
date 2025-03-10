package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
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
      return null;
  }


}

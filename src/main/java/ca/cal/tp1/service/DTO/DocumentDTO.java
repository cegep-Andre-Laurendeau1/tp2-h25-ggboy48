package ca.cal.tp1.service.DTO;

import ca.cal.tp1.modele.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
    private String titre;
    private LocalDate anneePublication;

    @Override
    public String toString() {
        return "DocumentDTO{" +
                ", titre='" + titre + '\'' +
                ", anneePublication=" + anneePublication +
                '}';
    }
    public DocumentDTO toDTO(Document document){
        return new DocumentDTO(document.getTitre(), document.getAnneePublication());
    }
}

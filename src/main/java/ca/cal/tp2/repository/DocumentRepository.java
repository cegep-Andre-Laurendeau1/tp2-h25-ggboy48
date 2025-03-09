package ca.cal.tp2.repository;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DocumentRepository extends JDBCRepositoryParent implements DocumentRepositoryInterface {

    @Override
    public void saveDocument(Document document) {
        String sqlDocument = "INSERT INTO Document VALUES (?, ?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlDocument)) {
            preparedStatement.setInt(1, document.getId());
            preparedStatement.setString(2, document.getTitre());
            preparedStatement.setString(3, document.getAuteur());
            preparedStatement.setInt(4, document.getAnneePublication());
            preparedStatement.setInt(5, document.getDureeEmprunt());
            preparedStatement.setInt(6, document.getNbrInventaires()); // Ajout du champ nbrInventaire


            preparedStatement.executeUpdate();

            // Si c'est un Livre, on insère aussi dans la table Livre
            if (document instanceof Livre livre) {
                String sqlLivre = "INSERT INTO Livre VALUES (?, ?, ?, ?);";
                try (PreparedStatement preparedStatementLivre = conn.prepareStatement(sqlLivre)) {
                    preparedStatementLivre.setInt(1, livre.getId());
                    preparedStatementLivre.setString(2, livre.getISBN());
                    preparedStatementLivre.setString(3, livre.getEditeur());
                    preparedStatementLivre.setInt(4, livre.getNbPages());
                    preparedStatementLivre.executeUpdate();
                }
            }

            // Si c'est un Cd, on insère aussi dans la table Cd
            if (document instanceof CD cd) {
                String sqlCd = "INSERT INTO CD VALUES (?, ?, ?, ?);";
                try (PreparedStatement preparedStatementCd = conn.prepareStatement(sqlCd)) {
                    preparedStatementCd.setInt(1, cd.getId());
                    preparedStatementCd.setString(2, cd.getArtiste());
                    preparedStatementCd.setInt(3, cd.getDuree());
                    preparedStatementCd.setString(4, cd.getGenre());
                    preparedStatementCd.executeUpdate();
                }
            }

            // Si c'est un DVD, on insère aussi dans la table DVD
            if (document instanceof DVD dvd) {
                String sqlCd = "INSERT INTO DVD VALUES (?, ?, ?, ?);";
                try (PreparedStatement preparedStatementDVD = conn.prepareStatement(sqlCd)) {
                    preparedStatementDVD.setInt(1, dvd.getId());
                    preparedStatementDVD.setString(2, dvd.getDirecteur());
                    preparedStatementDVD.setInt(3, dvd.getDuree());
                    preparedStatementDVD.setString(4, dvd.getRating());
                    preparedStatementDVD.executeUpdate();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Document> getAllDocuments() {
        List<Document> documents = new ArrayList<>();
        return documents;
    }

    @Override
    public void updateDocument(Document document) {

    }

    @Override
    public void deleteDocument(int documentID) {

    }

    @Override
    public Document getDocumentById(int id) {
        String sql = "SELECT * FROM Document WHERE id = ?;";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String titre = rs.getString("titre");
                String auteur = rs.getString("auteur");
                int annee = rs.getInt("anneePublication");
                int duree = rs.getInt("dureeEmprunt");
                int nbrInventaire = rs.getInt("nbrInventaires");

                // Vérifier si c'est un Livre
                String sqlLivre = "SELECT * FROM Livre WHERE id = ?;";
                try (PreparedStatement preparedStatementLivre = conn.prepareStatement(sqlLivre)) {
                    preparedStatementLivre.setInt(1, id);
                    ResultSet rsLivre = preparedStatementLivre.executeQuery();
                    if (rsLivre.next()) {
                        return new Livre(
                                id, titre, auteur, annee, duree, nbrInventaire,
                                rsLivre.getString("ISBN"), rsLivre.getString("editeur"),
                                rsLivre.getInt("nbPages")
                        );
                    }
                }

                // Vérifier si c'est un CD
                String sqlCd = "SELECT * FROM CD WHERE id = ?;";
                try (PreparedStatement preparedStatementCd = conn.prepareStatement(sqlCd)) {
                    preparedStatementCd.setInt(1, id);
                    ResultSet rsCd = preparedStatementCd.executeQuery();
                    if (rsCd.next()) {
                        return new CD(
                                id, titre, auteur, annee, duree, nbrInventaire,
                                rsCd.getString("artiste"), rsCd.getInt("duree"),
                                rsCd.getString("genre")
                        );
                    }
                }

                // Vérifier si c'est un DVD
                String sqlDvd = "SELECT * FROM DVD WHERE id = ?;";
                try (PreparedStatement preparedStatementDvd = conn.prepareStatement(sqlDvd)) {
                    preparedStatementDvd.setInt(1, id);
                    ResultSet rsDvd = preparedStatementDvd.executeQuery();
                    if (rsDvd.next()) {
                        return new DVD(
                                id, titre, auteur, annee, duree, nbrInventaire,
                                rsDvd.getString("directeur"), rsDvd.getInt("duree"),
                                rsDvd.getString("rating")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null; // Aucun document trouvé
    }




}

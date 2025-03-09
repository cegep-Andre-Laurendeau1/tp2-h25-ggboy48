package ca.cal.tp2.repository;

import ca.cal.tp2.modele.CD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CDRepository extends JDBCRepositoryParent implements CDRepositoryInterface{
    @Override
    public List<CD> getAllCDs() {
        List<CD> cds = new ArrayList<>();
        String sql = "SELECT * FROM Document WHERE id IN (SELECT id FROM CD)";

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                // Récupération des informations générales du document
                int id = resultSet.getInt("id");
                String titre = resultSet.getString("titre");
                String auteur = resultSet.getString("auteur");
                int anneePublication = resultSet.getInt("anneePublication");
                int dureeEmprunt = resultSet.getInt("dureeEmprunt");
                int nbrInventaires = resultSet.getInt("nbrInventaires");

                // Récupération des informations spécifiques au CD
                String sqlCD = "SELECT * FROM CD WHERE id = ?";
                try (PreparedStatement preparedStatementCD = conn.prepareStatement(sqlCD)) {
                    preparedStatementCD.setInt(1, id);
                    try (ResultSet rsCD = preparedStatementCD.executeQuery()) {
                        if (rsCD.next()) {
                            String artiste = rsCD.getString("artiste");
                            int duree = rsCD.getInt("duree");
                            String genre = rsCD.getString("genre");

                            // Création du CD en passant les informations de Document + CD
                            CD cd = new CD(id, titre, auteur, anneePublication, dureeEmprunt, nbrInventaires, artiste, duree, genre);
                            cds.add(cd);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching cds", e);
        }
        return cds;
    }

    @Override
    public CD getCDById(int id) {
        String sql = "SELECT * FROM Document WHERE id = ?";
        CD cd = null;
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Récupération des informations générales du document
                    String titre = resultSet.getString("titre");
                    String auteur = resultSet.getString("auteur");
                    int anneePublication = resultSet.getInt("anneePublication");
                    int dureeEmprunt = resultSet.getInt("dureeEmprunt");
                    int nbrInventaires = resultSet.getInt("nbrInventaires");

                    // Récupération des informations spécifiques au CD
                    String sqlCD = "SELECT * FROM CD WHERE id = ?";
                    try (PreparedStatement preparedStatementCD = conn.prepareStatement(sqlCD)) {
                        preparedStatementCD.setInt(1, id);
                        try (ResultSet rsCD = preparedStatementCD.executeQuery()) {
                            if (rsCD.next()) {
                                String artiste = rsCD.getString("artiste");
                                int duree = rsCD.getInt("duree");
                                String genre = rsCD.getString("genre");

                                // Création du CD en passant les informations de Document + CD
                                cd = new CD(id, titre, auteur, anneePublication, dureeEmprunt, nbrInventaires, artiste, duree, genre);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching cd by id", e);
        }
        return cd;
    }
}

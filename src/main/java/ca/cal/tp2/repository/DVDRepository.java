package ca.cal.tp2.repository;

import ca.cal.tp2.modele.DVD;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DVDRepository extends JDBCRepositoryParent implements DVDRepositoryInterface{
    @Override
    public List<DVD> getAllDVDs() {
        List<DVD> dvds = new ArrayList<>();
        String sql = "SELECT * FROM Document WHERE id IN (SELECT id FROM DVD)";

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

                // Récupération des informations spécifiques au DVD
                String sqlDVD = "SELECT * FROM DVD WHERE id = ?";
                try (PreparedStatement preparedStatementDVD = conn.prepareStatement(sqlDVD)) {
                    preparedStatementDVD.setInt(1, id);
                    try (ResultSet rsDVD = preparedStatementDVD.executeQuery()) {
                        if (rsDVD.next()) {
                            String directeur = rsDVD.getString("directeur");
                            int duree = rsDVD.getInt("duree");
                            String rating = rsDVD.getString("rating");

                            // Création du DVD en passant les informations de Document + DVD
                            DVD dvd = new DVD(id, titre, auteur, anneePublication, dureeEmprunt, nbrInventaires, directeur, duree, rating);
                            dvds.add(dvd);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching dvds", e);
        }
        return dvds;
    }

    @Override
    public DVD getDvDById(int id) {
        String sql = "SELECT * FROM Document WHERE id = ?";
        DVD dvd = null;
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

                    // Récupération des informations spécifiques au DVD
                    String sqlDVD = "SELECT * FROM DVD WHERE id = ?";
                    try (PreparedStatement preparedStatementDVD = conn.prepareStatement(sqlDVD)) {
                        preparedStatementDVD.setInt(1, id);
                        try (ResultSet rsDVD = preparedStatementDVD.executeQuery()) {
                            if (rsDVD.next()) {
                                String directeur = rsDVD.getString("directeur");
                                int duree = rsDVD.getInt("duree");
                                String rating = rsDVD.getString("rating");

                                // Création du DVD en passant les informations de Document + DVD
                                dvd = new DVD(id, titre, auteur, anneePublication, dureeEmprunt, nbrInventaires, directeur, duree, rating);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching dvd by id", e);
        }
        return dvd;
    }
}

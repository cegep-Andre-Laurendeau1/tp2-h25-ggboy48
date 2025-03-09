package ca.cal.tp2.repository;

import ca.cal.tp2.modele.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UtilisateurRepository extends JDBCRepositoryParent implements UtilisateurRepositoryInterface {

    @Override
    public void saveUtilisateur(Utilisateur utilisateur) {
        String sqlDocument = "INSERT INTO Utilisateur VALUES (?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlDocument)) {
            preparedStatement.setInt(1, utilisateur.getId());
            preparedStatement.setString(2, utilisateur.getNom());
            preparedStatement.setString(3, utilisateur.getPrenom());
            preparedStatement.setString(4, utilisateur.getEmail());
            preparedStatement.setString(5, utilisateur.getPhone());

            preparedStatement.executeUpdate();

            // Si c'est un Prepose, on insère aussi dans la table Livre
            if (utilisateur instanceof Prepose prepose) {
                String sqlPrepose = "INSERT INTO Prepose VALUES (?,?);";
                try (PreparedStatement preparedStatementPrepose = conn.prepareStatement(sqlPrepose)) {
                    preparedStatementPrepose.setInt(1, prepose.getId());
                    preparedStatementPrepose.setString(2, prepose.getRole());
                    preparedStatementPrepose.executeUpdate();
                }
            }

            // Si c'est un Emprunteur, on insère aussi dans la table Emprunteur
            if (utilisateur instanceof Emprunteur emprunteur) {
                String sqlEmprunteur = "INSERT INTO Emprunteur VALUES (?, ?);";
                try (PreparedStatement preparedStatementEmprunteur = conn.prepareStatement(sqlEmprunteur)) {
                    preparedStatementEmprunteur.setInt(1, emprunteur.getId());
                    preparedStatementEmprunteur.executeUpdate();
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Utilisateur getUtilisateurByID(int userID) {
        String sql = "SELECT * FROM Utilisateur WHERE id = ?;";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, userID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                // Vérifier si c'est un Emprunteur
                String sqlEmprunteur = "SELECT * FROM Emprunteur WHERE id = ?;";
                try (PreparedStatement preparedStatementEmprunteur = conn.prepareStatement(sqlEmprunteur)) {
                    preparedStatementEmprunteur.setInt(1, userID);
                    ResultSet rsEmprunteur = preparedStatementEmprunteur.executeQuery();

                    if (rsEmprunteur.next()) {
                        double amendes = rsEmprunteur.getDouble("amendes");
                        return new Emprunteur(userID, nom, prenom, email, phone);
                    }
                }

                // Vérifier si c'est un Prepose
                String sqlPrepose = "SELECT * FROM Prepose WHERE id = ?;";
                try (PreparedStatement preparedStatementPrepose = conn.prepareStatement(sqlPrepose)) {
                    preparedStatementPrepose.setInt(1, userID);
                    ResultSet rsPrepose = preparedStatementPrepose.executeQuery();

                    if (rsPrepose.next()) {
                        // Si l'utilisateur est un prepose
                        String role = rsPrepose.getString("role");
                        return new Prepose(userID, nom, prenom, email, phone, role);
                    }
                }


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return List.of();
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {

    }

    @Override
    public void deleteUtilisateur(int userID) {

    }


}

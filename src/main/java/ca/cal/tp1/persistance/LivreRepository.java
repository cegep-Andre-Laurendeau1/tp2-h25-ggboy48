package ca.cal.tp1.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ca.cal.tp1.modele.document.Cd;
import ca.cal.tp1.modele.document.Document;
import ca.cal.tp1.modele.document.Livre;

public class LivreRepository extends DocumentRepository{

    @Override
    public String getSql() {
        return "SELECT * FROM livre WHERE id = ?";
    }

    @Override
    public String saveSql() {
        return " INSERT INTO livre VALUES(?,?,?,?,?,?,?,?) ";
    }

    @Override
    public Document newDocument(ResultSet rs) throws SQLException {
        return new Livre(
                rs.getLong("id"),
                rs.getString("titre"),
                rs.getDate("anneepublication").toLocalDate(),
                rs.getInt("nombreexemplaire"),
                rs.getString("ISBN"),
                rs.getString("auteur"),
                rs.getString("editeur"),
                rs.getInt("nombrepages"));
    }
}

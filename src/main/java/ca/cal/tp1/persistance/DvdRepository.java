package ca.cal.tp1.persistance;

import ca.cal.tp1.modele.document.Cd;
import ca.cal.tp1.modele.document.Document;
import ca.cal.tp1.modele.document.Dvd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DvdRepository extends DocumentRepository {
    @Override
    public String getSql() {
        return "SELECT * FROM dvd WHERE id = ?";
    }

    @Override
    public String saveSql() {
        return "INSERT INTO dvd VALUES (?,?,?,?,?,?,?)";
    }

    @Override
    public Document newDocument(ResultSet rs) throws SQLException {
        return new Dvd(
                rs.getLong("id"),
                rs.getString("titre"),
                rs.getDate("anneepublication").toLocalDate(),
                rs.getInt("nombreexemplaire"),
                rs.getString("directeur"),
                rs.getInt("duree"),
                rs.getString("genre"));
    }
}

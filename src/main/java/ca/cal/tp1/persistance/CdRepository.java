package ca.cal.tp1.persistance;


import ca.cal.tp1.modele.document.Cd;
import ca.cal.tp1.modele.document.Document;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CdRepository extends DocumentRepository{

    @Override
    public String getSql() {
        return "SELECT * FROM cd WHERE id = ?";
    }

    @Override
    public String saveSql() {
        return "INSERT INTO cd VALUES (?,?,?,?,?,?,?)";
    }

    @Override
    public Document newDocument(ResultSet rs) throws SQLException {
        return new Cd(
                rs.getLong("id"),
                rs.getString("titre"),
                rs.getDate("anneepublication").toLocalDate(),
                rs.getInt("nombreexemplaire"),
                rs.getString("artiste"),
                rs.getInt("duree"),
                rs.getString("genre"));
    }


}

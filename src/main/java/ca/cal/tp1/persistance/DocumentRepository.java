package ca.cal.tp1.persistance;

import ca.cal.tp1.modele.document.Document;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DocumentRepository extends RepositoryParent{
    public void save(Document document) {
        String sql = saveSql();
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, document.getId());
            preparedStatement.setString(2, document.getTitre());
            preparedStatement.setDate(3, Date.valueOf(document.getAnneePublication()));
            preparedStatement.setInt(4, document.getNombreExemplaire());

            document.savePreparedStatement(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Document get(long l) {
        //@Override the get sql
        String sql = this.getSql();
        Document document = null;
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);){
            preparedStatement.setLong(1, l);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            if (rs.next())
                document = newDocument(rs);
                        //get result set of the repo from which this is
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return document;
    }
    public abstract String getSql();
    public abstract String saveSql();
    public abstract Document newDocument(ResultSet rs) throws SQLException;
}

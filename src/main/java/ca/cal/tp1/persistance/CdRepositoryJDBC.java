package ca.cal.tp1.persistance;


import ca.cal.tp1.DTO.CdDTO;
import ca.cal.tp1.modele.Cd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CdRepositoryJDBC extends RepositoryParent implements InterfaceRepository<Cd>{

    @Override
    public void save(Cd cd) {
        String sql ="INSERT INTO cd (id, titre, anneePublication, nombreExemplaire, artiste, duree, genre) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1, cd.getId());
            ps.setString(2, cd.getTitre());
            ps.setDate(3, java.sql.Date.valueOf(cd.getAnneePublication()));
            ps.setInt(4, cd.getNombreExemplaire());
            ps.setString(5, cd.getArtiste());
            ps.setInt(6, cd.getDuree());
            ps.setString(7, cd.getGenre());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cd get(Long id) {
        String sql = "SELECT * FROM cd WHERE id = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1, id);
            var result = ps.executeQuery();
            if(result.next()){
                return new Cd(
                        result.getLong("id"),
                        result.getString("titre"),
                        result.getDate("anneePublication").toLocalDate(),
                        result.getInt("nombreExemplaire"),
                        result.getString("artiste"),
                        result.getInt("duree"),
                        result.getString("genre")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM cd WHERE id = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

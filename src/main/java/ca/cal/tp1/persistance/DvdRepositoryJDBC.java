package ca.cal.tp1.persistance;

import ca.cal.tp1.DTO.DvdDTO;
import ca.cal.tp1.modele.Dvd;

import java.sql.PreparedStatement;

public class DvdRepositoryJDBC extends RepositoryParent implements InterfaceRepository<Dvd> {

    @Override
    public void save(Dvd dvd) {
        String sql = "INSERT INTO dvd (id, titre, anneePublication, nombreExemplaire, directeur, duree, genre) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1, dvd.getId());
            ps.setString(2, dvd.getTitre());
            ps.setDate(3, java.sql.Date.valueOf(dvd.getAnneePublication()));
            ps.setInt(4, dvd.getNombreExemplaire());
            ps.setString(5, dvd.getDirecteur());
            ps.setInt(6, dvd.getDuree());
            ps.setString(7, dvd.getGenre());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Dvd get(Long id) {
        String sql = "SELECT * FROM dvd WHERE id = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1, id);
            var result = ps.executeQuery();
            if(result.next()){
                return new Dvd(
                        result.getLong("id"),
                        result.getString("titre"),
                        result.getDate("anneePublication").toLocalDate(),
                        result.getInt("nombreExemplaire"),
                        result.getString("directeur"),
                        result.getInt("duree"),
                        result.getString("genre")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM dvd WHERE id = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

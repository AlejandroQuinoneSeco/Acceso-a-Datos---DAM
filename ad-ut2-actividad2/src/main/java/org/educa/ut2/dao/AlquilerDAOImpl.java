package org.educa.ut2.dao;

import org.educa.ut2.entity.AlquilerEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class AlquilerDAOImpl implements AlquilerDAO {
    @Override
    public List<AlquilerEntity> findAlquileresByMarca(String marca) {
        List<AlquilerEntity> alquileres = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM alquiler a inner join vehiculo v on v.id_vehiculo = a.id_vehiculo " +
                "where v.marca = ?;";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, marca);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    AlquilerEntity alquilerEntity = new AlquilerEntity();
                    alquilerEntity.setIdAlquiler(rs.getInt(1));
                    alquilerEntity.setFechaIni(rs.getDate(2).toLocalDate());
                    alquilerEntity.setFechaFin(rs.getDate(3).toLocalDate());
                    alquilerEntity.setIdCliente(rs.getInt(4));
                    alquilerEntity.setIdVehiculo(rs.getInt(5));
                    alquilerEntity.setIdSeguro(rs.getInt(6));
                    alquilerEntity.setPrecio(rs.getBigDecimal(7));
                    alquileres.add(alquilerEntity);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alquileres;
    }

    @Override
    public void updatePrecio(AlquilerEntity alquiler) {
        String sql = "UPDATE alquiler SET precio = ? where id_alquiler = ?";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setBigDecimal(1, alquiler.getPrecio());
            ps.setInt(2, alquiler.getIdAlquiler());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

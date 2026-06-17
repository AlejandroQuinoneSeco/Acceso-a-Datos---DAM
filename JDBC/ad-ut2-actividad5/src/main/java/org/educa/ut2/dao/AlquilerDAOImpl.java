package org.educa.ut2.dao;

import org.educa.ut2.entity.AlquilerEntity;
import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.entity.VehiculoEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlquilerDAOImpl implements AlquilerDAO {

    @Override
    public List<AlquilerEntity> findByPrecioInferior(double precio) {
        List<AlquilerEntity> alquileres = new ArrayList<>();
        String sql = "SELECT a.id_alquiler, a.fecha_ini, a.fecha_fin, c.nombre, v.matricula, v.bastidor " +
                "FROM alquiler a " +
                "INNER JOIN cliente c ON a.id_cliente = c.id_cliente " +
                "INNER JOIN vehiculo v ON v.id_vehiculo = a.id_vehiculo " +
                "WHERE a.precio < ?";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, precio);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    AlquilerEntity alquiler = new AlquilerEntity();
                    alquiler.setIdAlquiler(rs.getInt(1));
                    alquiler.setFechaIni(rs.getDate(2).toLocalDate());
                    alquiler.setFechaFin(rs.getDate(3).toLocalDate());

                    ClienteEntity cliente = new ClienteEntity();
                    cliente.setNombre(rs.getString(4));
                    alquiler.setCliente(cliente);

                    VehiculoEntity vehiculo = new VehiculoEntity();
                    vehiculo.setMatricula(rs.getString(5));
                    vehiculo.setBastidor(rs.getString(6));
                    alquiler.setVehiculo(vehiculo);

                    alquileres.add(alquiler);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alquileres;
    }
}

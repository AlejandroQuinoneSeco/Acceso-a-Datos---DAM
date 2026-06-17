package org.educa.ut2.dao;

import org.educa.ut2.entity.VehiculoEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.*;
import java.util.List;

public class VehiculoDAOImpl implements VehiculoDAO {


    @Override
    public VehiculoEntity findByBastidor(String bastidor) {
        VehiculoEntity vehiculo = new VehiculoEntity();
        String sql = "SELECT * FROM vehiculo WHERE bastidor = ?";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, bastidor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()){
                    vehiculo.setBastidor(bastidor);
                    vehiculo.setId(rs.getInt(1));
                    vehiculo.setMatricula(rs.getString(2));
                    vehiculo.setMarca(rs.getString(4));
                    vehiculo.setModelo(rs.getString(5));
                    vehiculo.setColor(rs.getString(6));
                    vehiculo.setAnyo(rs.getInt(7));
                    vehiculo.setCategoria(rs.getInt(8));
                    vehiculo.setSucursal(rs.getInt(9));
                    vehiculo.setCombustible(rs.getInt(10));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehiculo;
    }
}

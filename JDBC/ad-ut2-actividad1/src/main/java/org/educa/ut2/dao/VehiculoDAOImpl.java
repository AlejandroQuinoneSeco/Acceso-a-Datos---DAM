package org.educa.ut2.dao;

import org.educa.ut2.entity.VehiculoEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.*;
import java.util.List;

public class VehiculoDAOImpl implements VehiculoDAO {
    @Override
    public void insertAll(Connection conn, List<VehiculoEntity> vehiculoEntities) throws SQLException {
        try {
            for (VehiculoEntity vehiculo : vehiculoEntities) {
                vehiculo.setId(insertVehiculo(conn, vehiculo));
            }
        } catch (Exception e) {
            conn.rollback();
            throw new RuntimeException(e);
        }
    }

    private Integer insertVehiculo(Connection connection, VehiculoEntity vehiculo) {
        Integer generatedKey;
        String sql = "INSERT INTO vehiculo (matricula, bastidor, marca, modelo, color, anio, id_categoria, id_sucursal, id_comb) VALUES\n" +
                "(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, vehiculo.getMatricula());
            ps.setString(2, vehiculo.getBastidor());
            ps.setString(3, vehiculo.getMarca());
            ps.setString(4, vehiculo.getModelo());
            ps.setString(5, vehiculo.getColor());
            ps.setInt(6, vehiculo.getAnyo());
            ps.setInt(7, vehiculo.getCategoria());
            ps.setInt(8, vehiculo.getSucursal());
            ps.setInt(9, vehiculo.getCombustible());
            ps.executeUpdate();
            generatedKey = getIdFromInsert(ps);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return generatedKey;
    }

    public int getIdFromInsert(PreparedStatement stm) throws SQLException {
        try (ResultSet generatedKeys = stm.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("La operación de creación ha fallado, no ID obtenido.");
            }
        }
    }
}

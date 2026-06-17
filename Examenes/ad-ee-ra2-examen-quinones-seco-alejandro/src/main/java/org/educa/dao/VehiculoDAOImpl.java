package org.educa.dao;

import org.educa.entity.CombustibleEntity;
import org.educa.entity.VehiculoEntity;
import org.educa.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAOImpl implements VehiculoDAO{

    @Override
    public List<VehiculoEntity> findByCombustible(CombustibleEntity combustible) throws SQLException {
        List<VehiculoEntity> vehiculoEntities = new ArrayList<>();
        String sql = "SELECT id_vehiculo, matricula, bastidor FROM vehiculo WHERE id_comb = (?)";

        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, combustible.getId());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    VehiculoEntity vehiculo = new VehiculoEntity();
                    vehiculo.setId(rs.getInt("id_vehiculo"));
                    vehiculo.setMatricula(rs.getString("matricula"));
                    vehiculo.setBastidor(rs.getString("bastidor"));
                    vehiculo.setCombustible(combustible);

                    vehiculoEntities.add(vehiculo);
                }
            }
        }
        return vehiculoEntities;
    }
}

package org.educa.dao;

import org.educa.entity.AlquilerEntity;
import org.educa.entity.SeguroEntity;
import org.educa.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlquilerDAOImpl implements AlquilerDAO {
    /** Método para realizar una busqueda de alquileres por el nombre del seguro
     * @param seguro
     * @return lista de alquileres
     * @throws SQLException
     */
    @Override
    public AlquilerEntity findAlquiler(SeguroEntity seguro) throws SQLException {

        AlquilerEntity alquiler = new AlquilerEntity();
        String sql = "SELECT * FROM alquiler WHERE id_seguro = ?";

        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "id_alquiler");
            ps.setString(2, "fecha_ini");
            ps.setString(3, "fecha_fin");
            ps.setString(4, "id_cliente");
            ps.setString(5, "id_vehiculo");
            ps.setString(6, "id_seguro");
            ps.setString(7, "precio");


            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {

                    AlquilerEntity alquilerEntity = new AlquilerEntity();

                    alquilerEntity.setId(rs.getInt("id_alquiler"));
                    alquilerEntity.setFechaIni(rs.getDate("fecha_ini").toLocalDate());
                    alquilerEntity.setFechaFin(rs.getDate("fecha_fin").toLocalDate());
                    alquilerEntity.setId(rs.getInt("id_cliente"));
                    alquilerEntity.setId(rs.getInt("id_vehiculo"));
                    alquilerEntity.setId(rs.getInt("id_seguro"));
                    alquilerEntity.setPrecio(rs.getBigDecimal("precio"));

                }

            }
        }
        return alquiler;
    }
}

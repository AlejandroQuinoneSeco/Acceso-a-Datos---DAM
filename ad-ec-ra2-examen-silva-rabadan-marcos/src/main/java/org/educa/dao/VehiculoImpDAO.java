package org.educa.dao;

import org.educa.entity.VehiculoEntity;
import org.educa.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VehiculoImpDAO implements VehiculoDAO {
    @Override
    public VehiculoEntity findByMatricula(String matricula, int yearsOld) throws SQLException {
        VehiculoEntity vehiculoEntity = null;
        String sql = "SELECT * FROM vehiculo WHERE matricula = ? AND anio < ?";

        try (Connection con = ConnectionPool.getDataSource().getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, matricula);
            pst.setInt(2, yearsOld);

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {

                    vehiculoEntity = new VehiculoEntity();

                    vehiculoEntity.setIdVehiculo(rs.getInt("id_vehiculo"));
                    vehiculoEntity.setMatricula(rs.getString("matricula"));
                    vehiculoEntity.setBastidor(rs.getString("bastidor"));
                    vehiculoEntity.setMarca(rs.getString("marca"));
                    vehiculoEntity.setModelo(rs.getString("modelo"));
                    vehiculoEntity.setColor(rs.getString("color"));
                    vehiculoEntity.setAnio(rs.getInt("anio"));
                    vehiculoEntity.setIdCategoria(rs.getInt("id_categoria"));
                    vehiculoEntity.setIdSucursal(rs.getInt("id_sucursal"));
                    vehiculoEntity.setIdCombustible(rs.getInt("id_comb"));


                }

            }


        }
        return vehiculoEntity;
    }

    @Override
    public void deleteall(List<VehiculoEntity> vehiculoEntityList) throws SQLException {

        String sql = "DELETE FROM vehiculo WHERE id_vehiculo = ?";

        try (Connection con = ConnectionPool.getDataSource().getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            con.setAutoCommit(false);

            for (VehiculoEntity ve : vehiculoEntityList) {
                pst.setInt(1, ve.getIdVehiculo());

            }
            pst.executeUpdate();
            con.commit();

        }


    }

}

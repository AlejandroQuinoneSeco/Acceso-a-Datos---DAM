package org.educa.ut2.dao;

import org.educa.ut2.entity.EquipamientoEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipamientoDAOImpl implements EquipamientoDAO {
    @Override
    public List<EquipamientoEntity> findListaEquipamientos(String[] equipamientos) {
        List<EquipamientoEntity> equipamientoEntities = new ArrayList<>();
        for (String equipamiento : equipamientos) {
            EquipamientoEntity equipamientoEntity = findEquipamiento(equipamiento);
            equipamientoEntities.add(equipamientoEntity);
        }
        return equipamientoEntities;
    }

    @Override
    public List<EquipamientoEntity> findAllEquipamientos() {
        List<EquipamientoEntity> equipamientoEntities = new ArrayList<>();
        String sql = "SELECT * FROM equipamiento";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    EquipamientoEntity result = new EquipamientoEntity();
                    result.setId(rs.getInt(1));
                    result.setNombre(rs.getString(2));
                    result.setDescripcion(rs.getString(3));
                    equipamientoEntities.add(result);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return equipamientoEntities;
    }

    public EquipamientoEntity findEquipamiento(String nombre) {
        String sql = "SELECT * FROM equipamiento WHERE nombre = ?";
        EquipamientoEntity result = new EquipamientoEntity();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.setId(rs.getInt(1));
                    result.setNombre(rs.getString(2));
                    result.setDescripcion(rs.getString(3));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

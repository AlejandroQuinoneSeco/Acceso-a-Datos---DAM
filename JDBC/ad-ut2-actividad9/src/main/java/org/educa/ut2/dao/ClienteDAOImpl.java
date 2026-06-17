package org.educa.ut2.dao;

import org.educa.ut2.entity.ClienteEntity;

import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO {


    @Override
    public void insert(Connection connection, ClienteEntity cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nombre, p_apellido, s_apellido, email, dni, telefono) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // 1️⃣ Insertar cliente
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getPrimerApellido());
            preparedStatement.setString(3, cliente.getSegundoApellido().isEmpty() ? null : cliente.getSegundoApellido());
            preparedStatement.setString(4, cliente.getEmail());
            preparedStatement.setString(5, cliente.getDni());
            preparedStatement.setString(6, cliente.getTelefono().isEmpty() ? null : cliente.getTelefono());

            preparedStatement.executeUpdate();
            // 2️⃣ Recuperamos id cliente y lo insertamos en el cliente
            cliente.setIdCliente(getIdFromInsert(preparedStatement));

        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }


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

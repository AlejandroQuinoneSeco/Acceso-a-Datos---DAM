package org.educa.ut2.dao;

import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public ClienteEntity findByDNI(String dni) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE dni = ?";
        ClienteEntity cliente = null;

        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dni);
            ResultSet rsCliente = ps.executeQuery();

            if (rsCliente.next()) {
                cliente = new ClienteEntity(rsCliente.getInt("id_cliente"),
                        rsCliente.getString("nombre"),
                        rsCliente.getString("p_apellido"),
                        rsCliente.getString("s_apellido") == null ? "" : rsCliente.getString("s_apellido"),
                        rsCliente.getString("email"),
                        rsCliente.getString("dni"),
                        rsCliente.getString("telefono") == null ? "" : rsCliente.getString("telefono"),
                        new ArrayList<>()
                );
            }
        }
        return cliente;
    }
}

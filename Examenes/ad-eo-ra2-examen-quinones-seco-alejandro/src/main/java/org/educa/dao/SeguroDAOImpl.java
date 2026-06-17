package org.educa.dao;

import org.educa.entity.SeguroEntity;
import org.educa.pool.ConnectionPool;

import java.sql.*;

public class SeguroDAOImpl implements SeguroDAO{
    /** Metodo para realizar la inserción de seguros en la base de datos.
     * @param seguro el cual vamos a realizar la inserción en la base de datos.
     * @throws SQLException
     */
    @Override
    public void createSeguro(SeguroEntity seguro) throws SQLException {

        String sql = "INSERT INTO seguro (nombre, descripcion) VALUES (?, ?)";

        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, seguro.getNombre());
            ps.setString(2, seguro.getDescripcion());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rs.getInt(1);
                }
            }
        }
    }

    /** Metodo para realizar el borrado de un seguro en la base de datos.
     * @param nombre nombre del seguro que vamos a borrar.
     * @throws SQLException
     */
    @Override
    public void deleteSeguro(String nombre) throws SQLException {
        String nuevoNombre = nombre.toLowerCase().toUpperCase();


        String sql = "DELETE FROM seguro WHERE nombre = ?";

        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, nuevoNombre);
            ps.executeUpdate();


        }
    }

    /** Metodo para relizar una busqueda de seguros por nombre
     * @param nombre por el cual realizaremos la consulta del seguro
     * @return Lista de seguros que encontraremos
     * @throws SQLException
     */
    @Override
    public SeguroEntity findByNombre(String nombre) throws SQLException {
        SeguroEntity seguro = new SeguroEntity();
        String sql = "SELECT * FROM seguro WHERE nombre = ?";

        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, nombre);

        }
        return seguro;
    }
}

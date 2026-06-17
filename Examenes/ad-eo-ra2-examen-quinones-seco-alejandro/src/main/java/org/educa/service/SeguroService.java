package org.educa.service;

import org.educa.dao.SeguroDAO;
import org.educa.dao.SeguroDAOImpl;
import org.educa.entity.SeguroEntity;

import java.sql.SQLException;

public class SeguroService {

    private final SeguroDAO seguroDAO = new SeguroDAOImpl();


    /** Metodo para realizar la inserción de seguros en la base de datos.
     * @param seguro el cual vamos a realizar la inserción en la base de datos.
     * @throws SQLException
     */
    public void create(SeguroEntity seguro) {

        try {
            seguroDAO.createSeguro(seguro);
            System.out.println("Transaccion realizada con exito");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /** Metodo para relizar una busqueda de seguros por nombre
     * @param nombre por el cual realizaremos la consulta del seguro
     * @return Lista de seguros que encontraremos
     * @throws SQLException
     */
    public SeguroEntity findByNombre(String nombre) {

        try {
            seguroDAO.findByNombre(nombre);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    /** Metodo para realizar el borrado de un seguro en la base de datos.
     * @param nombre nombre del seguro que vamos a borrar.
     * @throws SQLException
     */
    public void remove(String nombre) {

        try {
            seguroDAO.deleteSeguro(nombre);
            System.out.println("Transccion realizada con exito");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

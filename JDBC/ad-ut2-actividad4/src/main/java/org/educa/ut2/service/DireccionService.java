package org.educa.ut2.service;

import org.educa.ut2.dao.DireccionDAO;
import org.educa.ut2.dao.DireccionDAOImpl;
import org.educa.ut2.entity.ClienteEntity;
import org.educa.ut2.entity.DireccionEntity;

import java.util.List;

public class DireccionService {
    private final DireccionDAO direccionDAO = new DireccionDAOImpl();
    public void loadDirecciones(List<ClienteEntity> clientes) {
        for (ClienteEntity cliente:clientes) {
            List<DireccionEntity> direcciones = direccionDAO.findDireccionByClienteId(cliente.getIdCliente());
            cliente.setDirecciones(direcciones);
        }
    }
}

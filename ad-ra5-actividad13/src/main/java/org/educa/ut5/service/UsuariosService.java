package org.educa.ut5.service;

import org.educa.ut5.dao.UsuarioDAO;
import org.educa.ut5.dao.UsuarioDAOImpl;
import org.educa.ut5.entity.UsuarioEntity;

public class UsuariosService {
    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    public Long delete(int id) {
        return usuarioDAO.delete(id);
    }
}

package org.educa.ut5.service;

import org.educa.ut5.dao.UsuarioDAO;
import org.educa.ut5.dao.UsuarioDAOImpl;
import org.educa.ut5.entity.UsuarioEntity;

public class UsuariosService {
    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    public void save(UsuarioEntity usuario) {
        usuarioDAO.save(usuario);
    }

    public UsuarioEntity findById(int id) {
        return usuarioDAO.findById(id);
    }

    public void update(UsuarioEntity usuario) {
        usuarioDAO.update(usuario);
    }
}

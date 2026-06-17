package org.educa.ut5.dao;

import org.educa.ut5.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioDAO {

    void save(UsuarioEntity usuario);

    UsuarioEntity findById(int id);

    void update(UsuarioEntity usuario);
}

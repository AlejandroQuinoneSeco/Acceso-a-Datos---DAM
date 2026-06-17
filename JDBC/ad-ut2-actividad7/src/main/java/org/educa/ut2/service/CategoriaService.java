package org.educa.ut2.service;

import org.educa.ut2.dao.CategoriaDAO;
import org.educa.ut2.dao.CategoriaDAOImpl;
import org.educa.ut2.entity.CategoriaEntity;

import java.util.List;

public class CategoriaService {
    private final CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

    public List<CategoriaEntity> findAll() {
        return categoriaDAO.findAll();
    }
}

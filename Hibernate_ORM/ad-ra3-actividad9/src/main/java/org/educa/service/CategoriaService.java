package org.educa.service;

import org.educa.dao.CategoriaDAO;
import org.educa.dao.CategoriaDAOImpl;
import org.educa.entity.CategoriaEntity;

import java.util.List;

public class CategoriaService {
    private final CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

    public List<CategoriaEntity> findAll() {
        return categoriaDAO.findAll();
    }
}

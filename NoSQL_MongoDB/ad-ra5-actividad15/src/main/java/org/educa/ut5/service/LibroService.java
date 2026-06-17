package org.educa.ut5.service;

import org.educa.ut5.dao.LibroDAO;
import org.educa.ut5.dao.LibroDAOImpl;
import org.educa.ut5.entity.LibroEntity;

import java.util.List;

public class LibroService {
    private final LibroDAO libroDAO = new LibroDAOImpl();

    public List<LibroEntity> findByTitle(String titulo) {
        return libroDAO.findByTitle(titulo);
    }
}

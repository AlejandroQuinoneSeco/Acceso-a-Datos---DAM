package org.educa.ut5.dao;

import org.educa.ut5.entity.LibroEntity;

import java.util.List;

public interface LibroDAO {
    List<LibroEntity> findByTitle(String titulo);
}

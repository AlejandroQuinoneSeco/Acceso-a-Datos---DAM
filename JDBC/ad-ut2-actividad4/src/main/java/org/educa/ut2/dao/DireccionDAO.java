package org.educa.ut2.dao;

import org.educa.ut2.entity.DireccionEntity;

import java.util.List;

public interface DireccionDAO {
    List<DireccionEntity> findDireccionByClienteId(Integer idCliente);
}

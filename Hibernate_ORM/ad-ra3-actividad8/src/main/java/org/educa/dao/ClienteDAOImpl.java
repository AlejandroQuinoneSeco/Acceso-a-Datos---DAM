package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.ClienteEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public ClienteEntity findById(int idCliente) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()){
            session.beginTransaction();
            ClienteEntity cliente = session.get(ClienteEntity.class, idCliente);
            Hibernate.initialize(cliente.getDirecciones());
            return cliente;
        }
    }
}

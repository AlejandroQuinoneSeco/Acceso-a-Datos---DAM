package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.ClienteEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public void save(ClienteEntity cliente) {
        try(Session session = HibernateConfiguration.getSessionFactory().openSession()){
            session.beginTransaction();
            try {
                session.persist(cliente);
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public ClienteEntity find(int id) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            ClienteEntity cliente = session.get(ClienteEntity.class, id);
            Hibernate.initialize(cliente.getDirecciones());
            return cliente;
        }
    }

    @Override
    public void update(ClienteEntity cliente) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            try {
                session.merge(cliente);
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public void remove(ClienteEntity cliente) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            try {
                session.remove(cliente);
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
            session.getTransaction().commit();
        }
    }
}

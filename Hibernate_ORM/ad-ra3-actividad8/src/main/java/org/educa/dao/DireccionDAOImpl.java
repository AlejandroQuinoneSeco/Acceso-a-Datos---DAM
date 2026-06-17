package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.DireccionEntity;
import org.hibernate.Session;

public class DireccionDAOImpl implements DireccionDAO {
    @Override
    public void remove(DireccionEntity direccionEntity) {
        try(Session session = HibernateConfiguration.getSessionFactory().openSession()){
            session.beginTransaction();
            try {
                session.remove(direccionEntity);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }
}

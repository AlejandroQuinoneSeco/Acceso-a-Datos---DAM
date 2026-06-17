package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.CombustibleEntity;
import org.hibernate.Session;

public class CombustibleDAOImpl implements CombustibleDAO {
    @Override
    public void save(CombustibleEntity combustibleEntity) {
        try(Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            try {
                session.persist(combustibleEntity);
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
            session.getTransaction().commit();
        }
    }
}

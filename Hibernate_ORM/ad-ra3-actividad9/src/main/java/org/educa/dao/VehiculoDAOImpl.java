package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.VehiculoEntity;
import org.hibernate.Session;

public class VehiculoDAOImpl implements VehiculoDAO {
    @Override
    public void save(VehiculoEntity vehiculoEntity) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            try {
                session.persist(vehiculoEntity);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }
}

package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.SucursalEntity;
import org.hibernate.Session;

public class SucursalDAOImpl implements SucursalDAO {
    @Override
    public void save(SucursalEntity sucursalEntity) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()){
            session.beginTransaction();
            session.persist(sucursalEntity);
            session.getTransaction().commit();
        }
    }
}

package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.CombustibleEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CombustibleDAOImpl implements CombustibleDAO {
    @Override
    public List<CombustibleEntity> findAll() {
        String hql = "FROM CombustibleEntity";
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<CombustibleEntity> query = session.createQuery(hql, CombustibleEntity.class);
            return query.list();
        }
    }
}

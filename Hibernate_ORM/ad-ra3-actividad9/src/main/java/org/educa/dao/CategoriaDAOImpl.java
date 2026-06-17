package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.CategoriaEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {
    @Override
    public List<CategoriaEntity> findAll() {
        String hql = "FROM CategoriaEntity";
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<CategoriaEntity> query = session.createQuery(hql, CategoriaEntity.class);
            return query.list();
        }
    }
}

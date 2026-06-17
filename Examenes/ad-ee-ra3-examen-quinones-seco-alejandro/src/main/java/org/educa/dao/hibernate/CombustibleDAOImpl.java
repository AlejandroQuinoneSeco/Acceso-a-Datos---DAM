package org.educa.dao.hibernate;

import org.educa.entity.CombustibleEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class CombustibleDAOImpl implements CombustibleDAO{
    @Override
    public void create(CombustibleEntity combustible) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
          try {
              session.beginTransaction();
              session.persist(combustible);
              session.getTransaction().commit();
          } catch (Exception e) {
              session.getTransaction().rollback();
              throw new RuntimeException(e);
          }
        }
    }

    @Override
    public CombustibleEntity findByNombre(String nombre) {
        CombustibleEntity combustible = null;
        String hql = "FROM CombustibleEntity WHERE LOWER(nombre) = :nombre";

        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                combustible = session.createQuery(hql, CombustibleEntity.class).setParameter("nombre", nombre.toLowerCase()).uniqueResult();
                if (combustible != null) {
                    Hibernate.initialize(combustible.getVehiculos());
                }
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RuntimeException(e);
            }
        }
        return combustible;
    }

    @Override
    public void remove(CombustibleEntity combustible) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                session.remove(combustible);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RuntimeException(e);
            }
        }
    }
}

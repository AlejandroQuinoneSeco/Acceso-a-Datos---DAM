package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.SucursalEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class SucursalmpDAO implements SucursalDAO {
    @Override
    public void insertSucursal(SucursalEntity sucursal) {

        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {

            try {

                session.beginTransaction();
                session.persist(sucursal);
                session.getTransaction().commit();

            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public SucursalEntity findByCp(String cp) {
        SucursalEntity sucursal = null;

        String hql = "FROM SucursalEntity s WHERE s.cp = :cp ";

        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();

            sucursal = session.createQuery(hql, SucursalEntity.class)
                    .setParameter("cp", cp).uniqueResult();

            if (sucursal != null) {

                Hibernate.initialize(sucursal.getVehiculos());

            }
            session.getTransaction().commit();

        }
        return sucursal;
    }

    @Override
    public List<SucursalEntity> findByCalle(String texto) {
        List<SucursalEntity> sucursalEntities = new ArrayList<>();

        String hql = "FROM SucursalEntity s WHERE LOWER (s.calle) LIKE LOWER (:texto) ";

        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {

            session.beginTransaction();
            sucursalEntities = session.createQuery(hql, SucursalEntity.class)
                    .setParameter("texto", "%" + texto + "%").getResultList();

            if (sucursalEntities != null) {

                for (SucursalEntity sucursal : sucursalEntities) {

                    Hibernate.initialize(sucursal.getVehiculos());

                }

            }
            session.getTransaction().commit();

        }
        return sucursalEntities;


    }

    @Override
    public void deleteSucursal(SucursalEntity sucursal) {

        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();

                session.remove(sucursal);

                session.getTransaction().commit();

            } catch (Exception e) {
                session.getTransaction().rollback();
            }


        }

    }
}

package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.AlquilerEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AlquilerDAOImpl implements AlquilerDAO {
    @Override
    public List<AlquilerEntity> findAlquileresByMarcaAndModelo(String marca, String modelo) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM AlquilerEntity a WHERE a.vehiculo.marca = :marca " +
                    "AND a.vehiculo.modelo = :modelo";
            Query<AlquilerEntity> query = session.createQuery(hql, AlquilerEntity.class)
                    .setReadOnly(true).setParameter("marca", marca)
                    .setParameter("modelo", modelo);
            return query.list();
        }
    }

    @Override
    public void update(List<AlquilerEntity> alquileres) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            try {
                for (AlquilerEntity alquiler : alquileres) {
                    session.merge(alquiler);
                }
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }
}

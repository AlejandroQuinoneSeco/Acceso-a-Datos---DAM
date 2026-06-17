package org.educa.dao;

import org.educa.configuration.HibernateConfiguration;
import org.educa.entity.AlquilerEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class AlquilerDAOImpl implements AlquilerDAO {
    @Override
    public AlquilerEntity findById(int idAlquiler) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            AlquilerEntity alquilerEntity = session.get(AlquilerEntity.class, idAlquiler);
            Hibernate.initialize(alquilerEntity.getVehiculo());
            Hibernate.initialize(alquilerEntity.getCliente());
            return alquilerEntity;
        }
    }
}

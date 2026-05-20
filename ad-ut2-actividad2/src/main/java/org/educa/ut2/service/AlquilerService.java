package org.educa.ut2.service;

import org.educa.ut2.dao.AlquilerDAO;
import org.educa.ut2.dao.AlquilerDAOImpl;
import org.educa.ut2.entity.AlquilerEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AlquilerService {
    private final AlquilerDAO alquilerDAO = new AlquilerDAOImpl();


    public void addDiscountToPriceByMarca(String marca, double discount) {

        List<AlquilerEntity> alquileres = alquilerDAO.findAlquileresByMarca(marca);
        double discountPercentage = discount / 100;
        for (AlquilerEntity alquiler : alquileres) {
            alquiler.setPrecio(alquiler.getPrecio().subtract(
                    alquiler.getPrecio().multiply(BigDecimal.valueOf(discountPercentage)))
                    .setScale(2, RoundingMode.HALF_UP));
            alquilerDAO.updatePrecio(alquiler);
        }
    }
}

package org.educa.service;

import org.educa.dao.AlquilerDAO;
import org.educa.dao.AlquilerDAOImpl;
import org.educa.entity.AlquilerEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AlquilerService {
    private final AlquilerDAO alquilerDAO = new AlquilerDAOImpl();

    public void aplicaDescuento(String marca, String modelo, BigDecimal descuento) {
        List<AlquilerEntity> alquileres =
                alquilerDAO.findAlquileresByMarcaAndModelo(marca, modelo);
        descuento = descuento.setScale(2, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
        for (AlquilerEntity alquiler : alquileres) {
            BigDecimal valorDescuento = alquiler.getPrecio().multiply(descuento);
            alquiler.setPrecio(alquiler.getPrecio().subtract(valorDescuento));
        }
        alquilerDAO.update(alquileres);
    }
}

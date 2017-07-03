package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.MesaDao;
import ar.edu.unlam.tallerweb1.dao.ReservaDao;
import ar.edu.unlam.tallerweb1.dao.RestaurantDao;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sebastian on 02/07/2017.
 */
@Service
@Transactional
public class ReservaServicioImpl implements ReservaServicio {
    @Inject
    private ReservaDao reservaDao;
    @Inject
    private RestaurantDao restaurantDao;
    @Inject
    private MesaDao mesaDao;
    @Override
    public List<Mesa> getMesasDisponibles(Date fecha, Long restaurantId) {
        Restaurant restaurant = restaurantDao.find(restaurantId);
        List<Long> mesasId = new ArrayList<>();
        for (Mesa mesa: restaurant.getMesas()) {
            mesasId.add(mesa.getId());
        }
        List<Mesa> mesasOcupadas = reservaDao.getMesasOcupadas(fecha,mesasId);
        List<Long> mesasOcupadasId = new ArrayList<>();
        for (Mesa mesa:mesasOcupadas) {
            mesasOcupadasId.add(mesa.getId());
        }

        if(mesasOcupadas.isEmpty()){
            return mesaDao.getMesas(restaurantId);
        }
        return reservaDao.getMesasDisponibles(mesasOcupadasId);
    }

    @Override
    public void save(Reserva item) {
        reservaDao.saveOrUpdate(item);
    }
}

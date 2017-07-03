package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.MesaDao;
import ar.edu.unlam.tallerweb1.dao.ReservaDao;
import ar.edu.unlam.tallerweb1.dao.RestaurantDao;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import com.sun.org.apache.xpath.internal.operations.Bool;
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

    @Override
    public Reserva get(Long id) {
        return reservaDao.find(id);
    }

    @Override
    public List<Mesa> getMesasDisponibles(Date fecha, Long restaurantId) {
        Restaurant restaurant = restaurantDao.find(restaurantId);
        List<Long> mesasId = new ArrayList<>();
        for (Mesa mesa : restaurant.getMesas()) {
            mesasId.add(mesa.getId());
        }
        List<Reserva> mesasOcupadas = reservaDao.getMesasOcupadas(fecha);

        List<Mesa> mesasDisponibles = new ArrayList<>();
        for (Mesa mesa : restaurant.getMesas()) {

            Boolean ocupada = false;
            for (Reserva reserva : mesasOcupadas) {
                if (reserva.getMesa().getId().equals(mesa.getId())) {
                    ocupada = true;
                }
            }

            if (!ocupada) {
                mesasDisponibles.add(mesa);
            }
        }


//        if(mesasOcupadas.isEmpty()){
//            return (List<Mesa>) restaurant.getMesas();
//        }

        return mesasDisponibles;
    }

    @Override
    public List<Reserva> reservasRestaurants(List<Restaurant> restaurants) {
        List<Long> mesasId = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            for (Mesa mesa : restaurant.getMesas()) {
                mesasId.add(mesa.getId());
            }
        }
        return reservaDao.getReservaByMesaId(mesasId);
    }


    @Override
    public void save(Reserva item) {
        reservaDao.saveOrUpdate(item);
    }
}

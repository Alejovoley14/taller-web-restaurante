package ar.edu.unlam.tallerweb1.servicios;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.DomicilioDao;
import ar.edu.unlam.tallerweb1.dao.MedioPagoDao;
import ar.edu.unlam.tallerweb1.dao.RestaurantDao;

import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.MedioPago;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

/**
 * Creado por matias
 */

@Service
@Transactional
public class RestaurantServicioImpl implements RestaurantServicio {
    @Inject
    private RestaurantDao restaurantDao;

    @Inject
    private DomicilioDao domicilioDao;
    @Inject
    private MedioPagoDao medioPagoDao;

    @Override
    public void add(Restaurant item, Domicilio domicilio, Long[] mediosPagoId) {

        Collection<MedioPago> mediosPago = new ArrayList<>();
        for (Long medioPago: mediosPagoId) {
            mediosPago.add(medioPagoDao.find(medioPago));
        }

        item.setMediosPago(mediosPago);

        restaurantDao.add(item);

        domicilio.setRestaurant(item);

        domicilioDao.add(domicilio);

//		for (MedioPago medioPago : mediosPago) {
//			restaurantDao.addMedioPago(id,medioPago.getId());
//		}

    }

    @Override
    public void update(Restaurant item, Domicilio domicilio,Long[] mediosPagoId) {
        Collection<MedioPago> mediosPago = new ArrayList<>();
        for (Long medioPago: mediosPagoId) {
            mediosPago.add(medioPagoDao.find(medioPago));
        }

        item.setMediosPago(mediosPago);

        restaurantDao.update(item);
        domicilioDao.update(domicilio);

    }


    @Override
    public Restaurant get(Long restaurantId) {
        Restaurant restaurant = restaurantDao.find(restaurantId);

        return restaurant;

    }


    @Override
    public List<Restaurant> getAll(Long userId) {

        List<Restaurant> restaurants = restaurantDao.getAllByUsuario(userId);
        return restaurants;

    }

    @Override
    public List<Restaurant> search(String nombre, Long localidadId) {
        return restaurantDao.search(nombre,localidadId);
    }


    @Override
    public Boolean exist(Long userId,Long restaurantId) {
        Restaurant restaurant = restaurantDao.restaurantFromUser(userId,restaurantId);
        return restaurant != null;
    }


}


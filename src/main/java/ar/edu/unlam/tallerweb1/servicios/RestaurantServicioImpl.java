package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.DomicilioDao;
import ar.edu.unlam.tallerweb1.dao.RestaurantDao;

import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

/**
 *  Creado por matias 
 */

@Service
@Transactional
public class RestaurantServicioImpl implements RestaurantServicio{
	@Inject 
	private RestaurantDao restaurantDao;

	@Inject
	private DomicilioDao domicilioDao;
	
	@Override
	public void add(Restaurant item,Domicilio domicilio){
		restaurantDao.add(item);
		domicilio.setRestaurant(item);
		domicilioDao.add(domicilio);
	}

	@Override
	public void update(Restaurant item, Domicilio domicilio) {
		restaurantDao.update(item);
		domicilioDao.update(domicilio);		
	}

	
	@Override
	public Restaurant get(Long restaurantId) {
		Restaurant restaurant=restaurantDao.find(restaurantId);
		
		return restaurant;
		
	}
	
	
	@Override
	public List<Restaurant> getAll(Long userId) {
		
		List<Restaurant> restaurants= restaurantDao.getAllByUsuario(userId);
		return restaurants; 
		
	}

	
	@Override
	public Boolean exist(Long restaurantId) {
		Restaurant restaurant= restaurantDao.find(restaurantId);

		return restaurant.getId()>0;	
	}
	
	
}



package ar.edu.unlam.tallerweb1.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.MedioPago;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

@Repository
public interface RestaurantDao extends GenericDao<Restaurant, Long>{
	List<Restaurant> getAllByUsuario(Long usuarioId);
	Restaurant restaurantFromUser(Long userId,Long restaurantId);
}
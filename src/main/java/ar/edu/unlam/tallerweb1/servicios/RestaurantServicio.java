package ar.edu.unlam.tallerweb1.servicios;
import java.util.List;
import java.util.Collection;

import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.MedioPago;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

public interface RestaurantServicio {
	void add(Restaurant item,Domicilio domicilio,Long[] mediosPagoId);
	void update(Restaurant item,Domicilio domicilio,Long[] mediosPagoId);
	Restaurant get(Long restaurantId);
	Boolean exist(Long userId,Long restaurantId);
	List<Restaurant> getAll(Long userId);
	List<Restaurant> search(String nombre,Long localidadId);
	Restaurant getByMesaId(Long mesaId);

}

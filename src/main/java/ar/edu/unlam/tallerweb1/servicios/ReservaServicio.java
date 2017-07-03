package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

import java.util.Date;
import java.util.List;

/**
 * Created by Sebastian on 02/07/2017.
 */
public interface ReservaServicio {
    Reserva get(Long id);
    List<Mesa> getMesasDisponibles(Date fecha,Long restaurantId);
    List<Reserva> reservasRestaurants(List<Restaurant> restaurants);
    void save(Reserva item);
}

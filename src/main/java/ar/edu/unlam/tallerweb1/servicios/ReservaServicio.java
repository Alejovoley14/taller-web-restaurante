package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

import java.util.Date;
import java.util.List;

/**
 * Created by Sebastian on 02/07/2017.
 */
public interface ReservaServicio {
    List<Mesa> getMesasDisponibles(Date fecha,Long restaurantId);
    void save(Reserva item);
}

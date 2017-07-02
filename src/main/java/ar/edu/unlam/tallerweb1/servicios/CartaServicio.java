package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Carta;
import ar.edu.unlam.tallerweb1.modelo.Mesa;

import java.util.List;

/**
 * Created by spardo on 13/6/2017.
 */
public interface CartaServicio {
    List<Carta> getCartas(List<Long> cartasId);
    Carta get(Long id);
    List<Carta> getAll(Long restaurantId, Long userId);
    List<Carta> getAll(Long restaurantId);
    void create(Carta item);
    void update(Carta item);
}

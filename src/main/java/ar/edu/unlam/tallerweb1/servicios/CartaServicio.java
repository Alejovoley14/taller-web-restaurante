package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Carta;

import java.util.List;

/**
 * Created by spardo on 13/6/2017.
 */
public interface CartaServicio {
    Carta get(Long id);
    List<Carta> getAll(Long restaurantId, Long userId);
    void create(Carta item);
    void update(Carta item);
}

package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Carta;

import java.util.List;

/**
 * Created by spardo on 13/6/2017.
 */
public interface CartaDao extends GenericDao<Carta,Long> {
    List<Carta> getAll(Long restaurantId, Long userId);
}

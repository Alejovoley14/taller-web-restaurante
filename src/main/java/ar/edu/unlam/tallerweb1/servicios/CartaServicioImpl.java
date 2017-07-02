package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.CartaDao;
import ar.edu.unlam.tallerweb1.modelo.Carta;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by spardo on 13/6/2017.
 */
@Service
@Transactional
public class CartaServicioImpl implements CartaServicio {
    @Inject
    private CartaDao cartaDao;

    @Override
    public List<Carta> getCartas(List<Long> cartasId) {
        return cartaDao.getCartas(cartasId);
    }

    @Override
    public Carta get(Long id) {
        return cartaDao.find(id);
    }

    @Override
    public List<Carta> getAll(Long restaurantId, Long userId) {
        return cartaDao.getAll(restaurantId, userId);
    }

    @Override
    public List<Carta> getAll(Long restaurantId) {
        return cartaDao.getAll(restaurantId);
    }

    @Override
    public void create(Carta item) {
        cartaDao.add(item);
    }

    @Override
    public void update(Carta item) {
        cartaDao.update(item);
    }
}

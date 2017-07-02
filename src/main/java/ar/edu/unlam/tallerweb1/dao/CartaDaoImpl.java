package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Carta;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by spardo on 13/6/2017.
 */
@Repository
public class CartaDaoImpl extends GenericDaoImpl<Carta,Long> implements CartaDao {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<Carta> getCartas(List<Long> cartasId) {
        final Session session = sessionFactory.getCurrentSession();


        return session.createCriteria(Carta.class)
                .add(Restrictions.in("id", cartasId)).list();
    }
    @Override
    public List<Carta> getAll(Long restaurantId, Long userId) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Carta.class)
                .createCriteria("restaurant")
                .add(Restrictions.eq("id", restaurantId))
                .createCriteria("usuario")
                .add(Restrictions.eq("id", userId)).list();
    }

    @Override
    public List<Carta> getAll(Long restaurantId) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Carta.class)
                .createCriteria("restaurant")
                .add(Restrictions.eq("id", restaurantId)).list();
    }
}

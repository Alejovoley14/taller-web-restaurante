package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by Sebastian on 02/07/2017.
 */
@Repository
public class ReservaDaoImpl extends GenericDaoImpl<Reserva,Long> implements ReservaDao {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<Mesa> getMesasOcupadas(Date fecha, Long restaurantId) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Mesa.class)
                .createCriteria("restaurant")
                .add(Restrictions.eq("id",restaurantId))
                .createCriteria("reserva")
                .add(Restrictions.eq("fecha",fecha)).list();


    }

    @Override
    public List<Mesa> getMesasDisponibles(List<Long> mesasOcupadasId) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Mesa.class)
                .add(Restrictions.not(Restrictions.in("id",mesasOcupadasId))).list();
    }
}

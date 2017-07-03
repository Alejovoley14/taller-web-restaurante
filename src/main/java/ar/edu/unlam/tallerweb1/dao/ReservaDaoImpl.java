package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
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
    public List<Reserva> getMesasOcupadas(Date fecha) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Reserva.class)
                .add(Restrictions.eq("fecha",fecha))
                .list();


    }

    @Override
    public List<Reserva> getReservaByMesaId(List<Long> mesasId) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Reserva.class)
                .add(Restrictions.isNull("asistencia"))
                .createCriteria("mesa")
                .add(Restrictions.in("id",mesasId))
                .list();
    }
}

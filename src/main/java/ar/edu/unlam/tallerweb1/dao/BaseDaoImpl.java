package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Entidad;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Sebastian on 26/04/2017.
 */

public class BaseDaoImpl<T extends Entidad> implements BaseDao<T> {

    @Inject
    protected SessionFactory sessionFactory;



    @Override
    public T save(final T item) {
        return (T) sessionFactory.getCurrentSession().save(item);
    }

    @Override
    public void delete(final T item) {
        sessionFactory.getCurrentSession().delete(item);
    }

    @Override
    public T get(final Class<T> type, final Long id) {

        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public T get(final Class<T> type, List<Criterion> criterions) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria criteria = session.createCriteria(type);
        criterions.forEach(c -> criteria.add(c));
        return (T) criteria.uniqueResult();
    }


    @Override
    public T merge(final T item) {
        return (T) sessionFactory.getCurrentSession().merge(item);
    }


    @Override
    public void saveOrUpdate(final T item) {
        sessionFactory.getCurrentSession().saveOrUpdate(item);
    }

    @Override
    public List<T> getAll(final Class<T> type) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        return crit.list();
    }

}

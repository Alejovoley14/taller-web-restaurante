package ar.edu.unlam.tallerweb1.dao;

import a.f.z;
import ar.edu.unlam.tallerweb1.modelo.Entidad;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.persister.entity.Queryable;

import javax.inject.Inject;
import javax.sql.rowset.Predicate;
import java.util.List;

/**
 * Created by Sebastian on 26/04/2017.
 */
public class BaseDaoImpl<T extends Entidad> implements BaseDao<T> {

    @Inject
    private SessionFactory sessionFactory;

    public <T> T save(final T item){
        return (T) sessionFactory.getCurrentSession().save(item);
    }

    public void delete(final T item){
        sessionFactory.getCurrentSession().delete(item);
    }

    public <T> T get(final Class<T> type,final Long id){

        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    public <T> T get(final Class<T> type,List<Criterion> criterions){
        final Session session = sessionFactory.getCurrentSession();
        final Criteria criteria = session.createCriteria(type);
        criterions.forEach(c->criteria.add(c));
        return (T) criteria.uniqueResult();
    }


    public <T> T merge(final T item)   {
        return (T) sessionFactory.getCurrentSession().merge(item);
    }


    public <T> void saveOrUpdate(final T item){
        sessionFactory.getCurrentSession().saveOrUpdate(item);
    }

    public <T> List<T> getAll(final Class<T> type) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        return crit.list();
    }


    public <T> List<T> getAll(final Class<T> type,List<Criterion> criterions){
        final Session session = sessionFactory.getCurrentSession();
        final Criteria criteria = session.createCriteria(type);
        criterions.forEach(c->criteria.add(c));
        return criteria.list();
    }
}

package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.dao.BaseDao;
import ar.edu.unlam.tallerweb1.modelo.Entidad;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Created by Sebastian on 26/04/2017.
 */
public class ServicioImpl<T extends Entidad> implements Servicio<T> {

    @Inject
    private BaseDao<T> servicioBaseDao;


    @Override
    public T get(final Class<T> type, final Long id) {

        return servicioBaseDao.get(type, id);
    }

    @Override
    public List<T> getAll(final Class<T> type) {
        return servicioBaseDao.getAll(type);
    }

    @Override
    public  T save(final T item) {
        return servicioBaseDao.save(item);
    }

    @Override
    public void delete(final T item) {
        servicioBaseDao.delete(item);
    }

    @Override
    public T merge(final T item) {
        return servicioBaseDao.merge(item);
    }

    @Override
    public void saveOrUpdate(final T item) {
        servicioBaseDao.saveOrUpdate(item);
    }
}

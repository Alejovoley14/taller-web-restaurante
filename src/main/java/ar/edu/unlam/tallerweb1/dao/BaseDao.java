package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Entidad;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Created by Sebastian on 26/04/2017.
 */
public interface BaseDao<T extends Entidad> {

    <T> T save(final T item);
    void delete(final T item);
    <T> T get(final Class<T> type,final Long id);
    <T> T get(final Class<T> type,List<Criterion> criterions);
    <T> T merge(final T item);
    <T> void saveOrUpdate(final T item);
    <T> List<T> getAll(final Class<T> type);
    <T> List<T> getAll(final Class<T> type,List<Criterion> criterions);

}

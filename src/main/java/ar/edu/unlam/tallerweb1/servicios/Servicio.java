package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Entidad;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Created by Sebastian on 28/04/2017.
 */
public interface Servicio <T extends Entidad> {
    T get(final Class<T> type,final Long id);
    List<T> getAll(final Class<T> type);
    T save(final T item);
    void delete(final T item);
    T merge(final T item);
    void saveOrUpdate(final T item);

}

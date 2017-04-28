package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Entidad;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Created by Sebastian on 28/04/2017.
 */
public interface Servicio <T extends Entidad> {
    <T> T save(final T item);
    void delete(final T item);

    <T> T merge(final T item);
    <T> void saveOrUpdate(final T item);

}

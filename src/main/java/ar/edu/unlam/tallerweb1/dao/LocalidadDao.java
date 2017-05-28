package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Localidad;

import java.util.List;

/**
 * Created by Sebastian on 28/05/2017.
 */
public interface LocalidadDao extends GenericDao<Localidad,Long> {
    List<Localidad> getAllByDepartamentoId(Long departamentoId);
}

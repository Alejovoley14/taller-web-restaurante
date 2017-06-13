package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.TipoProducto;

import java.util.List;

/**
 * Created by spardo on 13/6/2017.
 */
public interface TipoProductoDao extends GenericDao<TipoProducto,Long> {
    List<TipoProducto> getAllOrderByNombre();
}

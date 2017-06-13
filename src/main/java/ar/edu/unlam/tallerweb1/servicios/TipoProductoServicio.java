package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.TipoProducto;

import java.util.List;

/**
 * Created by spardo on 13/6/2017.
 */
public interface TipoProductoServicio {
    List<TipoProducto> getAllOrderByNombre();
    TipoProducto get(Long id);
}

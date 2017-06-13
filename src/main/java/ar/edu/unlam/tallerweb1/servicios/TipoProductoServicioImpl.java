package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.TipoProductoDao;
import ar.edu.unlam.tallerweb1.modelo.TipoProducto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by spardo on 13/6/2017.
 */
@Service
@Transactional
public class TipoProductoServicioImpl implements TipoProductoServicio {

    @Inject
    private TipoProductoDao tipoProductoDao;
    @Override
    public List<TipoProducto> getAllOrderByNombre() {
        return tipoProductoDao.getAllOrderByNombre();
    }

    @Override
    public TipoProducto get(Long id) {
        return tipoProductoDao.find(id);
    }
}

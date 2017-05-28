package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.ProvinciaDao;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Sebastian on 28/05/2017.
 */
@Service
@Transactional
public class ProvinciaServicioImpl  implements ProvinciaServicio{
    @Inject
    private ProvinciaDao provinciaDao;

    @Override
    public List<Provincia> getAll() {
        return provinciaDao.getAllOrderBy("descripcion");
    }
}

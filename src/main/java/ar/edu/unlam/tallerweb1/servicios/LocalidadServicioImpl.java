package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.LocalidadDao;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Sebastian on 28/05/2017.
 */
@Service
@Transactional
public class LocalidadServicioImpl implements LocalidadServicio {


    @Inject
    private LocalidadDao localidadDao;
    @Override
    public List<Localidad> getAllByDepartamentoId(Long departamentoId) {
        return localidadDao.getAllByDepartamentoId(departamentoId);
    }
}

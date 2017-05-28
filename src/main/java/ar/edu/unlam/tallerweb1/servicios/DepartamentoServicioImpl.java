package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.DepartamentoDao;
import ar.edu.unlam.tallerweb1.modelo.Departamento;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Sebastian on 28/05/2017.
 */
@Service
@Transactional
public class DepartamentoServicioImpl implements DepartamentoServicio {
    @Inject
    private DepartamentoDao departamentoDao;

    @Override
    public List<Departamento> getAllByProvinciaId(Long provinciaId) {
        return departamentoDao.getAllByProvincia(provinciaId);
    }
}

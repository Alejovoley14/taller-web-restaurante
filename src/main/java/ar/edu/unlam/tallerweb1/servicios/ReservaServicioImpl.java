package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.ReservaDao;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sebastian on 02/07/2017.
 */
@Service
@Transactional
public class ReservaServicioImpl implements ReservaServicio {
    @Inject
    private ReservaDao reservaDao;
    @Override
    public List<Mesa> getMesasDisponibles(Date fecha, Long restaurantId) {
        List<Mesa> mesasOcupadas = reservaDao.getMesasOcupadas(fecha,restaurantId);
        List<Long> mesasOcupadasId = new ArrayList<>();
        for (Mesa mesa:mesasOcupadas) {
            mesasOcupadasId.add(mesa.getId());
        }
        return reservaDao.getMesasDisponibles(mesasOcupadasId);
    }

    @Override
    public void save(Reserva item) {
        reservaDao.saveOrUpdate(item);
    }
}

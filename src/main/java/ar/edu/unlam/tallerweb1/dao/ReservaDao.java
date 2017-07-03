package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

import java.util.Date;
import java.util.List;

/**
 * Created by Sebastian on 02/07/2017.
 */
public interface ReservaDao extends GenericDao<Reserva,Long>  {
    List<Mesa> getMesasOcupadas(Date fecha, List<Long> mesasId);
    List<Mesa> getMesasDisponibles(List<Long> mesasOcupadasId);
}

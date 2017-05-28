package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import org.springframework.cglib.core.Local;

import java.util.List;

/**
 * Created by Sebastian on 28/05/2017.
 */
public interface LocalidadServicio {
    List<Localidad> getAllByDepartamentoId(Long departamentoId);
    Localidad get (Long id);
}

package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Domicilio;

/**
 * Created by Sebastian on 28/05/2017.
 */
public interface ClienteServicio {
    void add(Cliente item, Domicilio domicilio);
    void update(Cliente item, Domicilio domicilio);
    Cliente get(Long userId);
    Boolean exist(Long userId);
}

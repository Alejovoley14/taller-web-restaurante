package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;

/**
 * Created by Sebastian on 28/05/2017.
 */
public interface ClienteServicio {
    void add(Cliente item);
    void update(Cliente item);
    Cliente get(Long userId);
    Boolean exist(Long userId);
}

package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Departamento;

import java.util.List;

/**
 * Created by Sebastian on 28/05/2017.
 */
public interface DepartamentoServicio {
    List<Departamento> getAllByProvinciaId(Long provinciaId);
}

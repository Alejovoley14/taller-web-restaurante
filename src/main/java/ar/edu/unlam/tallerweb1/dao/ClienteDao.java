package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import org.springframework.stereotype.Repository;

/**
 * Created by Sebastian on 28/05/2017.
 */
@Repository
public interface ClienteDao extends GenericDao<Cliente, Long> {

}

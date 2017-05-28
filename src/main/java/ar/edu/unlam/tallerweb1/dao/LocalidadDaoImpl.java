package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Departamento;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Sebastian on 28/05/2017.
 */
@Repository
public class LocalidadDaoImpl extends GenericDaoImpl<Localidad, Long> implements LocalidadDao {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<Localidad> getAllByDepartamentoId(Long departamentoId) {

        final Session session = sessionFactory.openSession();
        return session.createCriteria(Localidad.class)
                .addOrder(Order.desc("descripcion"))
                .createCriteria("departamento")
                .add(Restrictions.eq("id", departamentoId)).list();
    }
}

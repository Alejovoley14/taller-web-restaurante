package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Departamento;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Sebastian on 28/05/2017.
 */
@Repository
public class DepartamentoDaoImpl extends GenericDaoImpl<Departamento, Long> implements DepartamentoDao {
    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<Departamento> getAllByProvincia(Long provinciaId) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Departamento.class)
                .addOrder(Order.desc("descripcion"))
                .createCriteria("provincia")
                .add(Restrictions.eq("id", provinciaId)).list();


    }
}

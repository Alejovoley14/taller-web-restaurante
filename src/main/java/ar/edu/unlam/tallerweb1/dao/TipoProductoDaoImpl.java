package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.TipoProducto;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by spardo on 13/6/2017.
 */
@Repository
public class TipoProductoDaoImpl extends GenericDaoImpl<TipoProducto,Long> implements TipoProductoDao{
    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<TipoProducto> getAllOrderByNombre(){
        return  currentSession().createCriteria(TipoProducto.class).addOrder(Order.desc("descripcion")).list();
    }
}

package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.MedioPago;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;


@Repository
public class RestaurantDaoImpl extends GenericDaoImpl<Restaurant, Long> implements RestaurantDao{
	  @Inject
	    private SessionFactory sessionFactory;
	  @Override
	    public List<Restaurant> getAllByUsuario(Long usuarioId) {
	        final Session session = sessionFactory.getCurrentSession();
	        return session.createCriteria(Restaurant.class)
	                .createCriteria("usuario")
	                .add(Restrictions.eq("id", usuarioId)).list();
	    }

	    public Restaurant restaurantFromUser(Long userId,Long restaurantId){
			final Session session = sessionFactory.getCurrentSession();
			return (Restaurant) session.createCriteria(Restaurant.class)
					.add(Restrictions.eq("id",restaurantId))
					.createCriteria("usuario")
					.add(Restrictions.eq("id", userId)).uniqueResult();
		}
}

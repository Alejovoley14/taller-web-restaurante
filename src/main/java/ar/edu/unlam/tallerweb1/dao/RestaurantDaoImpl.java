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
	        final Session session = sessionFactory.openSession();
	        return session.createCriteria(Restaurant.class)
	                .createCriteria("usuario")
	                .add(Restrictions.eq("id", usuarioId)).list();


	    }
	  
	  public void addMedioPago(Long restaurantId, Long medioPagoId) {
	        final Session session = sessionFactory.openSession();	        
	        session.beginTransaction();
	        Restaurant restaurant=(Restaurant)session.get(Restaurant.class, restaurantId);
	        MedioPago mediopago=(MedioPago)session.get(MedioPago.class,medioPagoId);
	        restaurant.getMediosPago().add(mediopago);
	        session.save(restaurant);
	        session.getTransaction().commit();
	    }
	  @Override
	  public Long addRestaurant(Restaurant restaurant) {
		  Long id=new Long(0);
	        final Session session = sessionFactory.openSession();
	       //Transaction trans=session.beginTransaction();
	        try{
	        session.save(restaurant);
	        id=restaurant.getId();     
	      //  trans.commit();  
	        }
	        catch(HibernateException he){}
	        return id;
	    }
	
}

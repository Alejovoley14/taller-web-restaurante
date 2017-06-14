package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import ar.edu.unlam.tallerweb1.modelo.Mesa;

@Repository
public class MesaDaoImpl extends GenericDaoImpl<Mesa,Long> implements MesaDao{

	@Inject
    private SessionFactory sessionFactory;//un servicio que fabrica sesiones

	@Override
	public List<Mesa> getMesas(Long restaurantId,Long userId){
		
		final Session session = sessionFactory.getCurrentSession();

	
		return session.createCriteria(Mesa.class)
				.createCriteria("restaurant")
				.add(Restrictions.eq("id", restaurantId)).createCriteria("usuario")
				.add(Restrictions.eq("id", userId)).list();

	}
	
	//los metodos de generic dao no me traen las cosas que quiero, defino nuevo metodo
	
	@Override
	public Mesa getMesa(Long idMesa){
		
		final Session session = sessionFactory.getCurrentSession();

		return (Mesa) session.createCriteria(Mesa.class)
				.add(Restrictions.eq("id", idMesa)).uniqueResult();
	}
}

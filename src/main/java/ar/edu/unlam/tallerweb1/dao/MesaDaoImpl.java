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
	public ArrayList<Mesa> getMesas(Long idRestaurante){
		
		final Session session = sessionFactory.getCurrentSession();
		
		ArrayList<Mesa> listaDeMesas = new ArrayList<Mesa>();
		
		listaDeMesas.add((Mesa) session.createCriteria(Mesa.class).list());
	
		return listaDeMesas;
		/*
		return (List<Mesa>) session.createCriteria(Mesa.class)
				.add(Restrictions.eq("",idRestaurante))//val1  val2 es el valor a buscar
				.list();
		*/
	}
	
	//los metodos de generic dao no me traen las cosas que quiero, defino nuevo metodo
	
	@Override
	public Mesa getMesa(Long idMesa){
		
		final Session session = sessionFactory.getCurrentSession();

		return (Mesa) session.createCriteria(Mesa.class)
				.add(Restrictions.eq("id", idMesa)).uniqueResult();
	}
}

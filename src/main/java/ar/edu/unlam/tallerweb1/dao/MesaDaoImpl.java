package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class MesaDaoImpl extends GenericDaoImpl<Mesa,Long> implements MesaDao{

	@Inject
    private SessionFactory sessionFactory;//un servicio que fabrica sesiones
	
	
	
	/*
	public List getMesas(){

		return null;
	}
	*/
	@Override
	public void saveMesa(Mesa mesa){
		
		final Session session = sessionFactory.openSession(); //esto genera una sesion en la base de datos. La sesion es de la interfaz de hibernate
		session.save(mesa);
	}

}

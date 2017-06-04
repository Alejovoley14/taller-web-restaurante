package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.MesaDao;
import ar.edu.unlam.tallerweb1.modelo.Mesa;

@Service("ServicioMesa")
@Transactional
public class ServicioMesaImpl implements ServicioMesa{
	
	@Inject
	private MesaDao mesaDao;
	
	/*
	public void getMesas(){
		
		System.out.println("se traeran las mesas");
	}

	public Mesa getMesa(){
		
		
		
		return null;
	}
	*/	
	@Override
	public void saveMesa(Mesa mesa){
		
		mesaDao.saveMesa(mesa);
	}
	/*
	public void deleteMesa(){
		
		
	}
	
	public void updateMesa(){
		
	}
*/
}

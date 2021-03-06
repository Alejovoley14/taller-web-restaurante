package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.MesaDao;
import ar.edu.unlam.tallerweb1.modelo.Mesa;

@Service("ServicioMesa")
@Transactional
public class  MesaServicioImpl implements MesaServicio {
	
	@Inject
	private MesaDao mesaDao;

	public List<Mesa> getMesas(Long restaurantId, Long userId){

		return mesaDao.getMesas(restaurantId,userId);
	}

	public Mesa getMesa(Long idMesa){

		return mesaDao.getMesa(idMesa);
	}
	
	@Override
	public void saveMesa(Mesa mesa){
		
		mesaDao.add(mesa);
	}
	
	public void deleteMesa(Mesa mesa){
		
		mesaDao.remove(mesa);
	}
	
	public void update(Mesa mesa){
		
		mesaDao.update(mesa);
	}

}

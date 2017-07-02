package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Mesa;

public interface MesaServicio {

	List<Mesa> getMesas(Long restaurantId, Long userId);
	
	Mesa getMesa(Long idMesa);
	
	void update(Mesa mesa);
	
	void deleteMesa(Mesa mesa);
	
	void saveMesa(Mesa mesa);
}

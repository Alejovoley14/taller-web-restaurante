package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Mesa;

public interface MesaServicio {
	
	public List<Mesa> getMesas(Long restaurantId,Long userId);
	
	public Mesa getMesa(Long idMesa);
	
	public void update(Mesa mesa);
	
	public void deleteMesa(Mesa mesa);
	
	public void saveMesa(Mesa mesa);
}

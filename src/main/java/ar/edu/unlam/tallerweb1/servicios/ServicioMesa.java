package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Mesa;

public interface ServicioMesa {
	
	public List<Mesa> getMesas(Long idRestaurant);
	
	public Mesa getMesa(Long idMesa);
	
	public void update(Mesa mesa);
	
	public void deleteMesa(Mesa mesa);
	
	public void saveMesa(Mesa mesa);
}

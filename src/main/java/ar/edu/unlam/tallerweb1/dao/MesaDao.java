package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

@Repository
public interface MesaDao extends GenericDao<Mesa, Long>{

	List<Mesa> getMesas(Long restaurantId, Long userId);
	
	Mesa getMesa(Long idMesa);
	}

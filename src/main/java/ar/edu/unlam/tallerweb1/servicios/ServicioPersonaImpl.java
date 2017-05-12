package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Persona;

@Service("ServicioPersona")// agrega el servicio que debe ser implementado
public class ServicioPersonaImpl implements ServicioPersona{
	
	@Override
	public ArrayList<Persona> filtrar(ArrayList<Persona> personas, Character genero){
		
		ArrayList<Persona> filtrados = new ArrayList<Persona>(); 
		
		for (Persona persona : personas) {
			
			if(persona.getGenero() == genero){
				
				filtrados.add(persona);
			}
			
		}
		return filtrados;
	}
}

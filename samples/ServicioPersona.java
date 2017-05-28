package ar.edu.unlam.tallerweb1.servicios;
import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.Persona;

public interface ServicioPersona {
	
	public ArrayList<Persona> filtrar(ArrayList<Persona> personas, Character genero);

}

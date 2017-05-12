package ar.edu.unlam.tallerweb1.modelo;

public class Persona {
	
	private String nombre;
	private Character genero;
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Character getGenero() {
		return genero;
	}



	public void setGenero(Character genero) {
		this.genero = genero;
	}



	public Persona(String nombre, Character genero){
		
		this.nombre = nombre;
		this.genero = genero;
	}
}

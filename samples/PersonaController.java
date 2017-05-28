package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Persona;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersona;


@Controller
public class PersonaController {
	
	@Inject
	private ServicioPersona servicio;
	
	@RequestMapping("personas/{genero}")
	public ModelAndView listaPersonas(@PathVariable("genero") Character genero){
		
		ArrayList<Persona> lista = new ArrayList<Persona>();
		lista.add(new Persona("matias",'m'));
		lista.add(new Persona("nico",'m'));
		lista.add(new Persona("laura",'f'));
		
		ArrayList<Persona> listaFiltrada = servicio.filtrar(lista, genero);
		
		ModelMap model = new ModelMap();
		model.put("listaFiltrada", listaFiltrada);
		
		return new ModelAndView("WEB-INF/vistas/personas.jsp",model);
	}
	
	
	
}

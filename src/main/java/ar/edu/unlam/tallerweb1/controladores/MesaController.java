package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Mesa;

@Controller
public class MesaController {
	
	@RequestMapping("/mesas")
	public ModelAndView grillaDeMesas(){
		
		ModelMap model = new ModelMap();
		Mesa mesaNueva = new Mesa(); //esta mesa es la que se envia como ModelAttribute
		model.put("mesaNueva",mesaNueva);
		
		ArrayList<Mesa> listadoDeMesas = new ArrayList<Mesa>();
		
		model.put("mesas",listadoDeMesas); //se le pasara una coleccion de mesas para usar dentro de un foreach
		
		return new ModelAndView("mesas",model);
	}
	
	@RequestMapping(path = "/registrar-mesa", method = RequestMethod.POST)
	public ModelAndView registrarMesa(@ModelAttribute("mesaNueva") Mesa mesaNueva){
		
		return null;
	}
}

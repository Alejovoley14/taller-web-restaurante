package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Carta;
import ar.edu.unlam.tallerweb1.modelo.TipoProducto;



@Controller
public class CartaController {
	
	@RequestMapping("/mostrar-carta")
	public ModelAndView vistaCarta() {

		ModelMap modelo = new ModelMap();		
		LinkedList<Carta> tablaCarta = new LinkedList<Carta>();
		Carta c1 = new Carta();
		c1.setId((long) 1);
		c1.setTitulo("menu1");
		c1.setDescripcion("Descripcion");
		c1.setPrecio((double) 150);
		tablaCarta.add(c1);
		
		Carta c2 = new Carta();
		c2.setId((long) 2);
		c2.setTitulo("menu2");
		c2.setDescripcion("Descripcion");
		c2.setPrecio((double) 150);
		tablaCarta.add(c2);
				
		modelo.put("carta", tablaCarta);
		return new ModelAndView("carta", modelo);
	}

//agregar menu 
	@RequestMapping(path = "/agregar-menu", method = RequestMethod.POST)
	public ModelAndView agregarMenu(@ModelAttribute("carta") Carta carta) {

		ModelMap model= new ModelMap();
		model.put("carta", carta);
		ArrayList<Carta> c = new ArrayList<Carta>();	
		for(Integer i=0;i< c.size();i++){			
			TipoProducto tipoProducto  = new TipoProducto();
			tipoProducto.setId(Long.parseLong("1"));
			tipoProducto.setDescripcion("descripción");
			carta.setTipoProducto(tipoProducto);
			c.add(carta);		
		}	
	return new ModelAndView("carta",model);
	}

//editar menu 	
     @RequestMapping(path = "/editar-menu/{cartaId}", method = RequestMethod.GET)
	 public ModelAndView editarMenu(@PathVariable("cartaId") Long cartaId,Carta carta) {
		
		ModelMap model= new ModelMap();
		model.put("carta", carta);
		ArrayList<Carta> c = new ArrayList<Carta>();
		for(Integer i=0;i< c.size();i++){
		
			if(c.equals (cartaId)){ //busco el mismo id para luego modificarlo
			TipoProducto tipoProducto  = new TipoProducto();
			tipoProducto.setId(Long.parseLong("1"));
			tipoProducto.setDescripcion("descripción");	
			carta.setTipoProducto(tipoProducto);
			}
		} 
	return new ModelAndView("carta",model);

	}


//eliminar menu 	
	@RequestMapping(path = "/eliminar-menu", method = RequestMethod.POST)
	public ModelAndView eliminarMenu(@ModelAttribute("carta") Carta carta) {

		ModelMap model= new ModelMap();
		model.put("carta", carta);
		ArrayList<Carta> c = new ArrayList<Carta>();
		
		for(Integer i=0;i< c.size();i++){	
			TipoProducto tipoProducto  = new TipoProducto();
			tipoProducto.setId(Long.parseLong("1"));
			tipoProducto.setDescripcion("descripción");
			carta.setTipoProducto(tipoProducto);
			c.remove(carta);	
		}	
	return new ModelAndView("carta",model);

	}

	
} 



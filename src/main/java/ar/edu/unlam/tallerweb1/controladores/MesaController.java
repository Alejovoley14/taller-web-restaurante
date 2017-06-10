package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.servicios.RestaurantServicio;
import ar.edu.unlam.tallerweb1.servicios.ServicioMesa;

@Controller
public class MesaController {
	
	//hay REquestMappings a los que debo agregarles variables de path restaurante y nro de mesa para que puedan funcionar
	//debo modificar la base de datos y el modelo Mesa para que pueda registrar los comensales por cada registro
	
	//defino datos de prueba
	//private Long idRestaurant = (long) 24;
	@Inject
	private ServicioMesa servicioMesa;
	
	@Inject
	private RestaurantServicio servicioRestaurant;
	
	private ArrayList<Mesa> listaPrueba(){
		
		ArrayList<Mesa> lista = new ArrayList<Mesa>();
		
		Mesa mesa1 = new Mesa();
		Mesa mesa2 = new Mesa();
		Mesa mesa3 = new Mesa();
		
		mesa1.setId((long) 1);
		mesa2.setId((long) 2);
		mesa3.setId((long) 3);
		
		mesa1.setAfuera(true);
		mesa2.setAfuera(true);
		mesa3.setAfuera(false);
		
		mesa1.setNumero(1);
		mesa2.setNumero(2);
		mesa3.setNumero(3);
		
		lista.add(mesa1);
		lista.add(mesa2);
		lista.add(mesa3);
		
		return lista;
	}
	
	
	
	@RequestMapping(value = "/mesas/{idRestaurant}")
	public ModelAndView grillaDeMesas(@PathVariable("idRestaurant") Long idRestaurant){
		
		ModelMap model = new ModelMap();

		List<Mesa> listadoDeMesas = new ArrayList<Mesa>();
		//listadoDeMesas = listaPrueba(); //solo se utiliza para insertar datos de prueba
		
		listadoDeMesas = servicioMesa.getMesas(idRestaurant); //metodo pendiente de testeo
		
		model.put("listadoDeMesas",listadoDeMesas); //se le pasara una coleccion de mesas para usar dentro de un foreach
		model.put("idRestaurant", idRestaurant);
		
		return new ModelAndView("mesas",model);
	}

	
	@RequestMapping(value="/mesa-nueva/{idRestaurant}")
	public ModelAndView nuevaMesa(@PathVariable("idRestaurant") Long idRestaurant){
		
		ModelMap model = new ModelMap();
		Mesa mesaNueva = new Mesa(); //esta mesa es la que se envia como ModelAttribute
		model.put("mesaNueva",mesaNueva);
		model.put("idRestaurant", idRestaurant);
		
		return new ModelAndView("mesa-nueva",model);
	}
	
	@RequestMapping(value = "/registrar-mesa/{idRestaurant}", method = RequestMethod.POST)//guardado de la mesa en bd
	public ModelAndView registrarMesa(@ModelAttribute("mesaNueva") Mesa mesaNueva,
			@PathVariable("idRestaurant") Long idRestaurant){
		
		Restaurant restaurant = servicioRestaurant.get(idRestaurant);

		mesaNueva.setRestaurant(restaurant);
		
		servicioMesa.saveMesa(mesaNueva);
		
		return new ModelAndView("redirect:/mesas/" + idRestaurant);
	}
	
	@RequestMapping(value="/eliminar-mesa/{idRestaurant}/{idMesa}", method = RequestMethod.GET)
	public ModelAndView eliminarMesa(@PathVariable("idMesa") Long idMesa,
			@PathVariable("idRestaurant") Long idRestaurant){
		
		//System.out.println("se eliminará la mesa " + numeroMesa);
		
		Mesa mesa = servicioMesa.getMesa(idMesa);
		
		mesa.setRestaurant(servicioRestaurant.get(idRestaurant));
		
		servicioMesa.deleteMesa(mesa);
		
		return new ModelAndView("redirect:/mesas/" + idRestaurant);
	}
	
	@RequestMapping(value="/editar-mesa/{idRestaurant}/{idMesa}")
	public ModelAndView editarMesaForm(
			@PathVariable("idRestaurant") Long idRestaurant,
			@PathVariable("idMesa") Long idMesa){
		
		ModelMap model = new ModelMap();
		model.put("mesa", servicioMesa.getMesa(idMesa));
		model.put("idRestaurant", idRestaurant);
		model.put("idMesa", idMesa);
		
		return new ModelAndView("editar-mesa",model);
	}
	
	@RequestMapping(value="modificar-mesa/{idRestaurant}/{idMesa}", method = RequestMethod.POST)
	public ModelAndView modificarMesa(
			@ModelAttribute("mesa") Mesa mesa,
			@PathVariable("idRestaurant") Long idRestaurant,
			@PathVariable("idMesa") Long idMesa){
		
		//System.out.println("se cambio la mesa" + idMesa);
		mesa.setRestaurant(servicioRestaurant.get(idRestaurant));//obtengo el restaurant con el servicio hecho por matias y lo guardo en la mesa
		//si no hago esto tomcat arroja error 500
		
		servicioMesa.update(mesa);
		
		return new ModelAndView("redirect:/mesas/" + idRestaurant);
	}
}

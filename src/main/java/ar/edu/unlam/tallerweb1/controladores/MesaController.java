package ar.edu.unlam.tallerweb1.controladores;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
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
import ar.edu.unlam.tallerweb1.servicios.MesaServicio;

@Controller
public class MesaController extends BaseController{
	
	//hay REquestMappings a los que debo agregarles variables de path restaurante y nro de mesa para que puedan funcionar
	//debo modificar la base de datos y el modelo Mesa para que pueda registrar los comensales por cada registro
	
	//defino datos de prueba
	//private Long idRestaurant = (long) 24;
	@Inject
	private MesaServicio servicioMesa;
	
	@Inject
	private RestaurantServicio servicioRestaurant;
	
	
	
	@RequestMapping(value = "/mesas/{restaurantId}")
	public ModelAndView grillaDeMesas(Principal principal,@PathVariable("restaurantId") Long restaurantId){
		
		ModelMap model = new ModelMap();
		Usuario user = getCurrentUser(principal);
		model.put("listadoDeMesas",servicioMesa.getMesas(restaurantId,user.getId())); //se le pasara una coleccion de mesas para usar dentro de un foreach
		model.put("restaurant",servicioRestaurant.get(restaurantId));
		model.put("idRestaurant", restaurantId);
		
		return new ModelAndView("mesa/mesas",model);
	}

	
	@RequestMapping(value="/mesa-nueva/{idRestaurant}")
	public ModelAndView nuevaMesa(@PathVariable("idRestaurant") Long idRestaurant){
		
		ModelMap model = new ModelMap();

		model.put("mesaNueva",new Mesa());
		model.put("idRestaurant", idRestaurant);
		
		return new ModelAndView("mesa/mesa-nueva",model);
	}
	
	@RequestMapping(value = "/registrar-mesa/{idRestaurant}", method = RequestMethod.POST)//guardado de la mesa en bd
	public ModelAndView registrarMesa(@ModelAttribute("mesaNueva") Mesa mesaNueva,
			@PathVariable("idRestaurant") Long idRestaurant){
		
		mesaNueva.setRestaurant(servicioRestaurant.get(idRestaurant));
		
		servicioMesa.saveMesa(mesaNueva);
		
		return new ModelAndView("redirect:/mesas/" + idRestaurant);
	}
	
	@RequestMapping(value="/eliminar-mesa/{idRestaurant}/{idMesa}", method = RequestMethod.GET)
	public ModelAndView eliminarMesa(@PathVariable("idMesa") Long idMesa,
			@PathVariable("idRestaurant") Long idRestaurant){

		
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
		
		return new ModelAndView("mesa/editar-mesa",model);
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

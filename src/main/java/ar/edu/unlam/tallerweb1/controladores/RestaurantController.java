package ar.edu.unlam.tallerweb1.controladores;

import java.security.Principal;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.MedioPago;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.extensions.MedioPagoEnum;
import ar.edu.unlam.tallerweb1.servicios.LocalidadServicio;
import ar.edu.unlam.tallerweb1.servicios.MedioPagoServicio;
import ar.edu.unlam.tallerweb1.servicios.ProvinciaServicio;
import ar.edu.unlam.tallerweb1.servicios.RestaurantServicio;
import ar.edu.unlam.tallerweb1.viewModels.RestaurantViewModel;

@Controller
public class RestaurantController extends BaseController{
	@Inject
	private RestaurantServicio restaurantServicio;
	@Inject 
	private ProvinciaServicio provinciaServicio;
	@Inject 
	private LocalidadServicio localidadServicio;
	@Inject 
	private MedioPagoServicio medioPagoServicio;
	
	@RequestMapping(value = "/restaurant", method = RequestMethod.GET)
	public ModelAndView getRestaurant(Principal principal){
		ModelMap model =new ModelMap();
		Usuario user=getCurrentUser(principal);
		model.put("lista", restaurantServicio.getAll(user.getId()));
		System.out.println("getRestaurant Controller"+ user.getId());///Delete
		return new ModelAndView("restaurant/getall",model);
	}
	
	@RequestMapping(value = "/restaurant/create", method = RequestMethod.GET)
	public ModelAndView CreateRestaurant(Principal principal){
		System.out.println("restaurant Controller");///Delete
		ModelMap model =new ModelMap();
		model.put("provincias", provinciaServicio.getAll());
		model.put("medioPagos", medioPagoServicio.getAll());
		model.put("restaurant", new RestaurantViewModel());
		return new ModelAndView("restaurant/create",model);
	}		
	
	
	@RequestMapping(value="/restaurant/add", method = RequestMethod.POST)
	public ModelAndView addRestaurant(Principal principal,@ModelAttribute("restaurant") RestaurantViewModel viewModel){
		System.out.println("restaurant/add Controller");
		//Localidad localidad=localidadServicio.get(viewModel.getLocalidadId());		
		Localidad localidad=localidadServicio.get(new Long(1));
		Restaurant restaurant = viewModel.toRestaurant(new Restaurant());
		restaurant.setUsuario(getCurrentUser(principal));
		Long[] medioDePagoIds=viewModel.getMedioDePagoIds();
		
		Collection<MedioPago> mp = new ArrayList<MedioPago>();
		
		MedioPago mediopago=new MedioPago();
		for (Long id : medioDePagoIds) {
			mediopago.setId(id);
		    mp.add(mediopago);
		}
		restaurantServicio.add(restaurant, viewModel.toDomicilio(new Domicilio(), localidad),mp);
		
		return new ModelAndView("redirect:/restaurant");		
	}
	
	@RequestMapping(value = "/restaurant/edit/{restaurantId}", method = RequestMethod.GET)
	public ModelAndView EditRestaurant(@PathVariable("restaurantId") Long restaurantId,Principal principal){
		System.out.println("restaurant Controller");///Delete
		ModelMap model =new ModelMap();
		Usuario user=getCurrentUser(principal);
		

		model.put("provincias", provinciaServicio.getAll());
		//model.put("medioPagos", medioPagoServicio.getAll());

		if(restaurantServicio.exist(restaurantId)){
			RestaurantViewModel viewModel= new RestaurantViewModel();
			Restaurant restaurant=restaurantServicio.get(restaurantId);
			
			restaurant.setUsuario(user);
			model.put("restaurant",viewModel.toViewModel(restaurant));
			return new ModelAndView("restaurant/edit",model);
		}
		return new ModelAndView("redirect:/restaurant");
	}	
	
	@RequestMapping(value="/restaurant/update",method=RequestMethod.POST)
	public ModelAndView updateRestaurant(Principal principal,@ModelAttribute("restaurant") RestaurantViewModel viewModel){
		Localidad localidad=localidadServicio.get(new Long(1));
		//Usuario user=getCurrentUser(principal);
		Restaurant restaurant=restaurantServicio.get(viewModel.getId());
		//Domicilio domicilio=restaurant.getDomicilios().iterator().next();
		Long[] selectedNumbers = viewModel.getMedioDePagoIds();
		
		Domicilio domicilio=new Domicilio();
		domicilio.setCalle("Islas Malvinas");
		domicilio.setNumero(123);
		domicilio.setLatitud(new Double(0));
		domicilio.setLongitud(new Double(0));
		
		restaurantServicio.update(viewModel.toRestaurant(restaurant), viewModel.toDomicilio(domicilio, localidad));
		
		return new ModelAndView("redirect:/restaurant");
	}
	
/*	
	@RequestMapping(value = "/prueba", method = RequestMethod.GET)
	public ModelAndView saveMedioPago(Principal principal){

		MedioPago mp =new MedioPago();
		mp.setDescripcion("Efectivo");
		mp.setTipo(MedioPagoEnum.TARJETACREDITO);
		medioPagoServicio.add(mp);
		return new ModelAndView("redirect:/restaurant");
	}
	*/
}

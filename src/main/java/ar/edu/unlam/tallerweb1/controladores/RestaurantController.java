package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.LocalidadServicio;
import ar.edu.unlam.tallerweb1.servicios.MedioPagoServicio;
import ar.edu.unlam.tallerweb1.servicios.ProvinciaServicio;
import ar.edu.unlam.tallerweb1.servicios.RestaurantServicio;
import ar.edu.unlam.tallerweb1.viewModels.RestaurantViewModel;
import ar.edu.unlam.tallerweb1.viewModels.serializables.RestaurantSerializable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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
	

public void setRestaurantServicio(RestaurantServicio restaurantServicio) {
		this.restaurantServicio = restaurantServicio;
	}

	public void setProvinciaServicio(ProvinciaServicio provinciaServicio) {
		this.provinciaServicio = provinciaServicio;
	}

	public void setLocalidadServicio(LocalidadServicio localidadServicio) {
		this.localidadServicio = localidadServicio;
	}

	public void setMedioPagoServicio(MedioPagoServicio medioPagoServicio) {
		this.medioPagoServicio = medioPagoServicio;
	}


	
	@RequestMapping(value = "/restaurant", method = RequestMethod.GET)
	public ModelAndView getRestaurant(Principal principal){
		ModelMap model =new ModelMap();
		Usuario user=getCurrentUser(principal);
		model.put("lista", restaurantServicio.getAll(user.getId()));

		return new ModelAndView("restaurant/getall",model);
	}
	
	@RequestMapping(value = "/restaurant/create", method = RequestMethod.GET)
	public ModelAndView CreateRestaurant(){
		ModelMap model =new ModelMap();
		model.put("provincias", provinciaServicio.getAll());
		model.put("medioPagos", medioPagoServicio.getAll());
		model.put("restaurant", new RestaurantViewModel());
		return new ModelAndView("restaurant/create",model);
	}		
	
	
	@RequestMapping(value="/restaurant/add", method = RequestMethod.POST)
	public ModelAndView addRestaurant(Principal principal,@ModelAttribute("restaurant") RestaurantViewModel viewModel){

		Localidad localidad = localidadServicio.get(viewModel.getDomicilio().getLocalidadId());

		Restaurant restaurant = viewModel.toRestaurant(new Restaurant());
		restaurant.setUsuario(getCurrentUser(principal));

		restaurantServicio.add(restaurant,viewModel.getDomicilio().toDomicilio(new Domicilio(),localidad),viewModel.getMedioDePagoIds());
		
		return new ModelAndView("redirect:/restaurant");		
	}
	
	@RequestMapping(value = "/restaurant/edit/{restaurantId}", method = RequestMethod.GET)
	public ModelAndView EditRestaurant(Principal principal,@PathVariable("restaurantId") Long restaurantId){

		ModelMap model =new ModelMap();
		Usuario user=getCurrentUser(principal);

		model.put("provincias", provinciaServicio.getAll());
		model.put("medioPagos", medioPagoServicio.getAll());

		if(restaurantServicio.exist(user.getId(),restaurantId)){
			RestaurantViewModel viewModel= new RestaurantViewModel();
			Restaurant restaurant=restaurantServicio.get(restaurantId);

			model.put("restaurant",viewModel.toViewModel(restaurant));

			return new ModelAndView("restaurant/edit",model);
		}

		return new ModelAndView("redirect:/restaurant");
	}	
	
	@RequestMapping(value="/restaurant/update",method=RequestMethod.POST)
	public ModelAndView updateRestaurant(Principal principal,@ModelAttribute("restaurant") RestaurantViewModel viewModel){


		Localidad localidad = localidadServicio.get(viewModel.getDomicilio().getLocalidadId());

		Usuario user=getCurrentUser(principal);
		if(restaurantServicio.exist(user.getId(),viewModel.getId())){

			Restaurant restaurant=restaurantServicio.get(viewModel.getId());


			restaurantServicio.update(viewModel.toRestaurant(restaurant),viewModel.getDomicilio().toDomicilio(new Domicilio(),localidad),viewModel.getMedioDePagoIds());

		}


		return new ModelAndView("redirect:/restaurant");
	}
	@RequestMapping(value = "/restaurant/search")
	public ModelAndView searcgRestaurants(Principal principal){

		ModelMap model = new ModelMap();
		Usuario user = getCurrentUser(principal);
		Domicilio clienteDomicilio = user.getCliente().iterator().next().getDomicilios().iterator().next();
		model.put("latLong",clienteDomicilio.getLatitud() + "," + clienteDomicilio.getLongitud());
		model.put("provincias", provinciaServicio.getAll());
		return new ModelAndView("restaurant/search",model);
	}

	@RequestMapping(value = "/restaurant/query",method = RequestMethod.GET)
	@ResponseBody
	public List<RestaurantSerializable> queryRestaurants(@RequestParam(value = "nombre",required = false)String nombre, @RequestParam(value = "localidadId",required = false)Long localidadId){

		List<Restaurant> restaurants = restaurantServicio.search(nombre,localidadId);
		List<RestaurantSerializable> returnList = new ArrayList<>();
		for (Restaurant restaurant: restaurants) {
			returnList.add(new RestaurantSerializable(restaurant));
		}
		return returnList;
	}

}

package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Mesa;

@Controller
public class MesaController {
	
	//hay REquestMappings a los que debo agregarles variables de path restaurante y nro de mesa para que puedan funcionar
	//debo modificar la base de datos y el modelo Mesa para que pueda registrar los comensales por cada registro
	
	//defino datos de prueba
	//private Long idRestaurant = (long) 24;
	
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

		ArrayList<Mesa> listadoDeMesas = new ArrayList<Mesa>();
		listadoDeMesas = listaPrueba(); //solo se utiliza para insertar datos de prueba
		model.put("listadoDeMesas",listadoDeMesas); //se le pasara una coleccion de mesas para usar dentro de un foreach
		model.put("idRestaurant", idRestaurant);
		
		return new ModelAndView("mesas",model);
	}
	
	/*
	@RequestMapping(value = "/mesas")
	public ModelAndView grillaDeMesas(){
		
		ModelMap model = new ModelMap();

		ArrayList<Mesa> listadoDeMesas = new ArrayList<Mesa>();
		listadoDeMesas = listaPrueba(); //solo se utiliza para insertar datos de prueba
		model.put("listadoDeMesas",listadoDeMesas); //se le pasara una coleccion de mesas para usar dentro de un foreach
		//model.put("idRestaurant", idRestaurant);
		
		return new ModelAndView("mesas",model);
	}
	*/
	
	@RequestMapping(value="/mesa-nueva/{idRestaurant}")
	public ModelAndView nuevaMesa(@PathVariable("idRestaurant") Long idRestaurant){

		ModelMap model = new ModelMap();
		Mesa mesaNueva = new Mesa(); //esta mesa es la que se envia como ModelAttribute
		model.put("mesaNueva",mesaNueva);
		
		return new ModelAndView("mesa-nueva",model);
	}
	
	@RequestMapping(value = "/registrar-mesa", method = RequestMethod.POST)
	public ModelAndView registrarMesa(@ModelAttribute("mesaNueva") Mesa mesaNueva){
		
		System.out.printf("numero: %d\tposicion: %s\n", mesaNueva.getNumero(), mesaNueva.getAfuera());
		
		return new ModelAndView("redirect:/mesas");
	}
	
	@RequestMapping(value="/eliminar-mesa/{id}", method = RequestMethod.GET)
	public ModelAndView eliminarMesa(@PathVariable("id")Long idMesa){
		
		System.out.println("se eliminará la mesa " + idMesa);
		return new ModelAndView("redirect:/mesas");
	}
	
	@RequestMapping(value="/editar-mesa/{idRestaurant}/{numeroMesa}")
	public ModelAndView editarMesaForm(
			@PathVariable("idRestaurant") Long idRestaurant,
			@PathVariable("numeroMesa") Integer numeroMesa){
		
		//se debera consultar por servicio el restaurant y la mesa para poder editar
		ModelMap model = new ModelMap();
		//creo una mesa para probar la edicion
		Mesa mesaDePrueba = new Mesa();
		mesaDePrueba.setNumero(numeroMesa);
		mesaDePrueba.setId((long)1);
		mesaDePrueba.setAfuera(false);
		
		model.put("mesa", mesaDePrueba);
		
		return new ModelAndView("editar-mesa",model);
	}
	
	@RequestMapping(value="modificar-mesa/{idRestaurant}", method = RequestMethod.POST)
	public ModelAndView modificarMesa(
			@ModelAttribute("mesa") Mesa mesa,
			@PathVariable("idRestaurant") Long idRestaurant){
		
		System.out.println("se cambio la mesa");
		
		return new ModelAndView("redirect:/mesas/" + idRestaurant);
	}
}

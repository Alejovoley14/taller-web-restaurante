




package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.Principal;
import java.security.Security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.social.facebook.api.Post;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.RestaurantController;
import ar.edu.unlam.tallerweb1.modelo.MedioPago;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.RestaurantServicio;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class RestaurantControllerTest {
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before("")	
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void getRestaurantsHappyPath () {
		//Mock de Principal
		ServicioLogin servicioLoginFake=mock(ServicioLogin.class);
		Collection<GrantedAuthority> authority = new HashSet<GrantedAuthority>();
		User user = new User("prueba", "", authority);		
		TestingAuthenticationToken token = new TestingAuthenticationToken(user, null);
		SecurityContextHolder.getContext().setAuthentication(token);
		Usuario usuarioFake=mock(Usuario.class);		
		when(servicioLoginFake.getByName("prueba")).thenReturn(usuarioFake);		
				
		RestaurantServicio restaurantServicioFake = mock(RestaurantServicio.class);
		List<Restaurant> restaurants = new ArrayList<>();
				
		when(restaurantServicioFake.getAll(new Long(0))).thenReturn(restaurants);		
		RestaurantController controlador = new RestaurantController();	
		controlador.setRestaurantServicio(restaurantServicioFake);
	    controlador.setServicioLogin(servicioLoginFake);
		
		ModelAndView modelAndView=controlador.getRestaurant(token);			
		
		assertThat(modelAndView.getViewName()).isEqualTo("restaurant/getall");
		
	}

}


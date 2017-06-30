
package ar.edu.unlam.tallerweb1;


import org.junit.Test;
import org.mockito.BDDMockito.Then;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;



public class ControladorLoginTest {
	@Test
	public void consultarUsuarioExistente () {
		
		//Todas las instancias deben ser MOCK
		Usuario usuarioPrueba = mock(Usuario.class);
		ServicioLogin servicioLoginFake = mock(ServicioLogin.class);
		
		when(servicioLoginFake.consultarUsuario(usuarioPrueba)).thenReturn(usuarioPrueba);
		
		
		ControladorLogin controlador = new ControladorLogin();
		
		//Setearle al controlador el servicio mockeado
		controlador.setServicioLogin(servicioLoginFake);
		
		ModelAndView modelAndView = controlador.validarLogin(usuarioPrueba);
		

		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home");
		
	}
	
	@Test
	public void consultarUsuarioInexistente () {
	
		//Todas las instancias deben ser MOCK
		Usuario usuarioPrueba = mock(Usuario.class);
		ServicioLogin servicioLoginFake = mock(ServicioLogin.class);
		
		when(servicioLoginFake.consultarUsuario(usuarioPrueba)).thenReturn(null);
		
		ControladorLogin controlador = new ControladorLogin();
		
		//Setearle al controlador el servicio mockeado
		controlador.setServicioLogin(servicioLoginFake);
		
		ModelAndView modelAndView = controlador.validarLogin(usuarioPrueba);
		
		verify(usuarioPrueba, times(0)).getEmail();
		assertThat(modelAndView.getModelMap().get("error")).isEqualTo("Usuario o clave incorrecta");
		assertThat(modelAndView.getViewName()).isEqualTo("login");
	}

}

package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;
	
	@RequestMapping("/autenticar")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario) {
		ModelMap model = new ModelMap();

		if (servicioLogin.consultarUsuario(usuario) != null) {
			return new ModelAndView("redirect:/home");
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}

//	@Secured("")
//	@RequestMapping(path = "/home", method = RequestMethod.GET)
//	public ModelAndView irAHome() {
//		return new ModelAndView("home");
//	}
//
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		ModelMap model = new ModelMap();
		Usuario user = new Usuario();
		model.put("user",user);
		return new ModelAndView("home",model);
//		return new ModelAndView("redirect:/login");
	}
}

package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ClienteServicio;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.security.Principal;

/**
 * Created by Sebastian on 14/05/2017.
 */
@Controller
public class HomeController extends BaseController{

    @Inject
    private ClienteServicio clienteServicio;
    @Inject
    private ServicioLogin servicioLogin;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView irAHome(Principal principal) {
        ModelMap modelo = new ModelMap();

        modelo.put("existeCliente",clienteServicio.exist(getCurrentUser(principal).getId()));


        return new ModelAndView("home", modelo);

    }


}

package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ClienteServicio;
import ar.edu.unlam.tallerweb1.servicios.ProvinciaServicio;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.security.Principal;

/**
 * Created by Sebastian on 28/05/2017.
 */
@Controller
public class ClienteController extends BaseController {

    @Inject
    private ClienteServicio clienteServicio;
    @Inject
    private ProvinciaServicio provinciaServicio;

    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public ModelAndView getCliente(Principal principal) {
        ModelMap model = new ModelMap();
        Usuario user = getCurrentUser(principal);

        model.put("provincias", provinciaServicio.getAll());

        if (clienteServicio.exist(user.getId())) {
            model.put("cliente", clienteServicio.get(user.getId()));
            return new ModelAndView("cliente/create", model);
        }

        model.put("cliente", new Cliente());
        return new ModelAndView("cliente/create", model);
    }
}

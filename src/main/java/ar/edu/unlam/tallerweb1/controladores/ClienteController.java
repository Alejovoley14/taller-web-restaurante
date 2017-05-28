package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ClienteServicio;
import ar.edu.unlam.tallerweb1.servicios.LocalidadServicio;
import ar.edu.unlam.tallerweb1.servicios.ProvinciaServicio;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.viewModels.ClienteViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    @Inject
    private LocalidadServicio localidadServicio;

    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public ModelAndView getCliente(Principal principal) {
        ModelMap model = new ModelMap();
        Usuario user = getCurrentUser(principal);

        model.put("provincias", provinciaServicio.getAll());

        if (clienteServicio.exist(user.getId())) {
            ClienteViewModel viewModel = new ClienteViewModel();
            model.put("cliente", viewModel.toViewModel(clienteServicio.get(user.getId())));
            return new ModelAndView("cliente/edit", model);
        }

        model.put("cliente", new ClienteViewModel());
        return new ModelAndView("cliente/create", model);
    }

    @RequestMapping(value = "/cliente/add", method = RequestMethod.POST)
    public ModelAndView addCliente(Principal principal, @ModelAttribute("cliente") ClienteViewModel viewModel) {

        Localidad localidad = localidadServicio.get(viewModel.getLocalidadId());

        clienteServicio.add(viewModel.toCliente(new Cliente(), localidad));

        //Validar
        return new ModelAndView("redirect:/cliente");

    }

    @RequestMapping(value = "/cliente/update", method = RequestMethod.POST)
    public ModelAndView updateCliente(Principal principal, @ModelAttribute("cliente") ClienteViewModel viewModel) {

        Localidad localidad = localidadServicio.get(viewModel.getLocalidadId());

        Usuario user = getCurrentUser(principal);
        Cliente cliente = clienteServicio.get(user.getId());

        clienteServicio.update(viewModel.toCliente(cliente, localidad));
        //Validar
        return new ModelAndView("redirect:/cliente");

    }
}

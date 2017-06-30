package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import java.security.Principal;

/**
 * Created by Sebastian on 28/05/2017.
 */
@Controller
public class BaseController {
    @Inject
    private ServicioLogin servicioLogin;

    protected Usuario getCurrentUser(Principal principal){
        return servicioLogin.getByName(principal.getName());
    }
    public void setServicioLogin(ServicioLogin servicioLogin) {
		this.servicioLogin = servicioLogin;
	}

}

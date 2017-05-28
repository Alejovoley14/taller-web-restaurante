package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.viewModels.UsuarioViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * Created by Sebastian on 27/05/2017.
 */
@Controller
public class UserController {

    @Inject
    private ServicioLogin servicioLogin;

    @RequestMapping(value = "/CrearUsuario",method = RequestMethod.POST)
    public ModelAndView crearUsuario(@ModelAttribute("usuario") UsuarioViewModel usuario){
        ModelMap model = new ModelMap();

        if(servicioLogin.userExist(usuario.getEmail())){
            model.put("error", "Ya existe el usuario");
        }else if(!usuario.getPassword().equals(usuario.getVerifyPassword())){
            model.put("error", "Las contraseñas no coinciden");
            model.put("usuario",usuario);
        }else{
            model.put("success", "Usuario creado con exito, ya puede iniciar sesión");
            servicioLogin.crearUsuario(usuario.ToUsuario());
        }
        return new ModelAndView("login", model);
    }
}

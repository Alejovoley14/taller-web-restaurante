package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sebastian on 14/05/2017.
 */
@Controller
public class HomeController {

//    @RequestMapping(path = "/", method = RequestMethod.GET)
//    public ModelAndView irAHome() {
//        ModelMap modelo = new ModelMap();
//        Usuario usuario = new Usuario();
//        modelo.put("usuario", usuario);
//        return new ModelAndView("home", modelo);
//
//    }
//
//    @RequestMapping(path = "/validate-credentials",method = RequestMethod.POST)
//    public ModelAndView validateCredentials(Usuario usuario){
//
//    }

}

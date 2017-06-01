package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.viewModels.SocialSigInViewModel;
import ar.edu.unlam.tallerweb1.viewModels.UsuarioViewModel;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.apache.http.protocol.HTTP.USER_AGENT;

/**
 * Created by Sebastian on 27/05/2017.
 */
@Controller
public class UserController {

    @Inject
    private ServicioLogin servicioLogin;


    @RequestMapping(value = "CrearUsuario", method = RequestMethod.POST)
    public ModelAndView crearUsuario(@ModelAttribute("usuario") UsuarioViewModel usuario) {
        ModelMap model = new ModelMap();

        if (servicioLogin.userExist(usuario.getEmail())) {
            model.put("error", "Ya existe el usuario");
        } else if (!usuario.getPassword().equals(usuario.getVerifyPassword())) {
            model.put("error", "Las contraseñas no coinciden");
            model.put("usuario", usuario);
        } else {
            model.put("success", "Usuario creado con exito, ya puede iniciar sesión");
            servicioLogin.crearUsuario(usuario.ToUsuario());
        }
        return new ModelAndView("login", model);
    }

    @RequestMapping(value = "socialLogin", method = RequestMethod.POST,headers = "Accept=application/json")
    @ResponseBody
    public ModelAndView logInSocial(@RequestParam SocialSigInViewModel model) {



        if (!servicioLogin.userExist(model.getEmail())) {
            servicioLogin.crearUsuario(model.getUsuario());
        }

        doAutoLogin(model.getEmail());

        return new ModelAndView("redirect:/");

    }


    private void doAutoLogin(String username) {

        Authentication authentication = new UsernamePasswordAuthenticationToken(username, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }


}

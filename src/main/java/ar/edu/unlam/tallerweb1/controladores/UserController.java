package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.utils.SecurityUtil;
import ar.edu.unlam.tallerweb1.viewModels.UsuarioViewModel;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * Created by Sebastian on 27/05/2017.
 */
@Controller
public class UserController {

    @Inject
    private ServicioLogin servicioLogin;
    @Inject
    private ProviderSignInUtils providerSignInUtils;

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

    @RequestMapping(value = "/access",method = RequestMethod.GET)
    public ModelAndView acces(WebRequest request){

        String[] bits = request.getDescription(true).split(";");
        String username = bits[bits.length-1].replace("user=","");
        Usuario user = servicioLogin.getByName(username);
        SecurityUtil.logInUser(user);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public ModelAndView registerAndSignIn(WebRequest request, Model model){
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);

        Usuario user = doSocialRegister(connection);

        SecurityUtil.logInUser(user);
        providerSignInUtils.doPostSignUp(user.getEmail(), request);

        return new ModelAndView("redirect:/cliente");
    }

    private Usuario doSocialRegister(Connection<?> connection){
        UserProfile socialMediaProfile = connection.fetchUserProfile();

        ConnectionKey providerKey = connection.getKey();

        if(!servicioLogin.userExist(socialMediaProfile.getEmail())){
            Usuario user = new Usuario();
            user.setEmail(socialMediaProfile.getEmail());
            user.setProvider(providerKey.getProviderId());
            user.setPassword("");
            return servicioLogin.crearUsuario(user);
        }

        return servicioLogin.getByName(socialMediaProfile.getEmail());
    }

}

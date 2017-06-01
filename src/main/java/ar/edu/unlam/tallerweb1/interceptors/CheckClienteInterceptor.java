package ar.edu.unlam.tallerweb1.interceptors;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ClienteServicio;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/**
 * Created by Sebastian on 30/05/2017.
 */
public class CheckClienteInterceptor extends HandlerInterceptorAdapter {

    @Inject
    private ClienteServicio clienteServicio;
    @Inject
    private ServicioLogin servicioLogin;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Principal principal = (Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario user = servicioLogin.getByName(principal.getName());

        if(!clienteServicio.exist(user.getId()))
            response.sendRedirect("/");

        return true;
    }
}

package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ServicioLogin {

	Usuario consultarUsuario(Usuario usuario);
}

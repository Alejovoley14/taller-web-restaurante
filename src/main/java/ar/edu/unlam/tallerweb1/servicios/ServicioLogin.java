package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ServicioLogin{

	Usuario consultarUsuario(Usuario usuario);

	void crearUsuario(Usuario usuario);

	Boolean userExist(String username);
	Usuario getByName(String username);
}

package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ServicioLogin{

	Usuario consultarUsuario(Usuario usuario);

	Usuario crearUsuario(Usuario usuario);

	Boolean userExist(String username);
	Usuario getByName(String username);


}

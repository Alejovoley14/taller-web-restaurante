package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioLogin extends Servicio<Usuario> {

	Usuario consultarUsuario(Usuario usuario);
}

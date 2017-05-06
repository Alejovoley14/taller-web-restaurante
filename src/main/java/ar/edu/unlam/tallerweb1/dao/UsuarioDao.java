package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface UsuarioDao extends BaseDao<Usuario> {
	
	Usuario consultarUsuario (Usuario usuario);
}

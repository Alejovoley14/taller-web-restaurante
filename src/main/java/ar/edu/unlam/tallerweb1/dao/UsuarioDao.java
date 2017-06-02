package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface UsuarioDao extends GenericDao<Usuario,Long>{

    Usuario consultarUsuario(Usuario usuario);
    Usuario getByName(String name);
    Usuario saveAndGet(Usuario item);
}

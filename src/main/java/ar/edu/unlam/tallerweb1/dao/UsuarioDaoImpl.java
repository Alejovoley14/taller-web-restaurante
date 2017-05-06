package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@Service("usuarioDao")
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario> implements UsuarioDao{

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Usuario consultarUsuario(Usuario usuario) {
        List<Criterion> criterios = new LinkedList<Criterion>();

        criterios.add(Restrictions.eq("email", usuario.getEmail()));
        criterios.add(Restrictions.eq("password", usuario.getPassword()));

        return super.get(Usuario.class,criterios);
	}

}

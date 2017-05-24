package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@Service("usuarioDao")
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario> implements UsuarioDao{

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
	public Usuario consultarUsuario(Usuario usuario) {
        List<Criterion> criterios = new LinkedList<Criterion>();

        criterios.add(Restrictions.eq("email", usuario.getEmail()));
        criterios.add(Restrictions.eq("password", usuario.getPassword()));

        return super.get(Usuario.class,criterios);
	}

    @Override
    public Usuario getByUserName(String username) {
        final Session session = sessionFactory.openSession();
        return (Usuario) session.createCriteria(Usuario.class)
                .add(Restrictions.eq("email",username))
                .uniqueResult();
    }



}

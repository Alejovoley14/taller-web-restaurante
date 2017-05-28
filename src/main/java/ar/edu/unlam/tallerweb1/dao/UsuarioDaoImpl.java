package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@Repository
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario,Long> implements UsuarioDao {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public Usuario consultarUsuario(Usuario usuario) {

        final Session session = sessionFactory.openSession();
        return (Usuario) session.createCriteria(Usuario.class)
                .add(Restrictions.eq("email", usuario.getEmail()))
                .add(Restrictions.eq("password", usuario.getPassword()))
                .uniqueResult();
    }

    @Override
    public Usuario getByName(String name) {
        final Session session = sessionFactory.openSession();
        return (Usuario) session.createCriteria(Usuario.class)
                .add(Restrictions.eq("email", name))
                .uniqueResult();
    }


}

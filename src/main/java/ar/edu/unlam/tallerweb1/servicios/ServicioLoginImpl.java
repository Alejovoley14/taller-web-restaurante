package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.TypedValue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.LinkedList;
import java.util.List;


@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl extends ServicioImpl<Usuario> implements ServicioLogin {

	@Inject
	private UsuarioDao servicioLoginDao;

	@Override
	public Usuario consultarUsuario (Usuario usuario) {

//		return servicioLoginDao.consultarUsuario(usuario);

		List<Criterion> criterios = new LinkedList<Criterion>();

		criterios.add(Restrictions.eq("email", usuario.getEmail()));
		criterios.add(Restrictions.eq("password", usuario.getPassword()));

		return super.getItem(Usuario.class,criterios);
	}

}

package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.plugin.util.UserProfile;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl extends ServicioImpl<Usuario> implements ServicioLogin, UserDetailsService {


    @Inject
    private UsuarioDao servicioLoginDao;

    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        return servicioLoginDao.consultarUsuario(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario user = servicioLoginDao.getByUserName(s);

        if (user == null) {

            Usuario nuevo = new Usuario();
            nuevo.setEmail("prueba2");
            nuevo.setPassword("prueba2");
            servicioLoginDao.save(nuevo);
            user = servicioLoginDao.getByUserName(nuevo.getEmail());

            if (user == null)
                throw new UsernameNotFoundException("No se encontro el usuario");
        }
        return new User(user.getEmail(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Usuario user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        if (!user.getRestaurants().isEmpty()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_Restaurant"));
        }

        return authorities;
    }
}

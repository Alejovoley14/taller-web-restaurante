package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.Social.MesaVipSocialUser;
import ar.edu.unlam.tallerweb1.Social.Role;
import ar.edu.unlam.tallerweb1.dao.GenericDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;


@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin, UserDetailsService {



    @Inject
    private UsuarioDao usuarioDao;

    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        return usuarioDao.consultarUsuario(usuario);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        if(usuario.getPassword() == null){
            usuario.setPassword("");
        }
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(hashedPassword);

        return usuarioDao.saveAndGet(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario user = usuarioDao.getByName(s);

        if (user == null)
            throw new UsernameNotFoundException("No se encontro el usuario");

        return new User(user.getEmail(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    @Override
    public Boolean userExist(String username){
        Usuario user = usuarioDao.getByName(username);
        return user != null;
    }

    @Override
    public Usuario getByName(String username) {
        return usuarioDao.getByName(username);
    }

    private List<GrantedAuthority> getGrantedAuthorities(Usuario user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        if (!user.getRestaurants().isEmpty()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_Restaurant"));
        }

        return authorities;
    }
}

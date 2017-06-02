package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.Social.MesaVipSocialUser;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

import javax.inject.Inject;

/**
 * Created by Sebastian on 02/06/2017.
 */
public class SocialUserDetalServiceImpl implements SocialUserDetailsService {

    private UserDetailsService userDetailsService;
    @Inject
    private ServicioLogin servicioLogin;


    public SocialUserDetalServiceImpl(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException, DataAccessException {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
        Usuario user = servicioLogin.getByName(userDetails.getUsername());

        Cliente cliente = null;

        if(!user.getCliente().isEmpty()){
            cliente = user.getCliente().iterator().next();
        }

        MesaVipSocialUser principal = MesaVipSocialUser.getBuilder()
                .firstName(cliente != null ? cliente.getNombre() : "")
                .id(user.getId())
                .lastName(cliente != null ? cliente.getApellido() : "")
                .password(user.getPassword())
                .username(user.getEmail())
                .build();
        return principal;
    }
}

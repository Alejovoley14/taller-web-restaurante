package ar.edu.unlam.tallerweb1.utils;

import ar.edu.unlam.tallerweb1.Social.Role;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.security.SocialUser;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sebastian on 02/06/2017.
 */
public class SecurityUtil {
    public static void logInUser(Usuario user) {

        Set<GrantedAuthority> authorities = new HashSet<>();
        if (user.getRestaurants().size() > 1) {
            authorities.add(new SimpleGrantedAuthority("ROLE_RESTAURANT"));
        }

        SocialUser userDetails = new SocialUser(user.getEmail(), user.getPassword(), authorities);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}

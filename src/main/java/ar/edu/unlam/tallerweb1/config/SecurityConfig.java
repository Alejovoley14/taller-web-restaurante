package ar.edu.unlam.tallerweb1.config;

/**
 * Created by Sebastian on 13/05/2017.
 */

import ar.edu.unlam.tallerweb1.servicios.SocialUserDetalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("servicioLogin")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/css/**","/js/**","/fonts/**","/login","/CrearUsuario","/connect/**").permitAll()
//                .anyRequest().fullyAuthenticated().and().formLogin().loginPage("/login")
//                .failureUrl("/login?error").and().logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
//                .exceptionHandling().accessDeniedPage("/access?error");

        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/authenticate")
                .failureUrl("/login?error")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                .exceptionHandling().accessDeniedPage("/access?error")
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/css/**",
                        "/js/**",
                        "/fonts/**",
                        "/login",
                        "/CrearUsuario",
                        "/auth/**",
                        "/signup/**",
                        "/user/register/**",
                        "/connect/**"
                ).permitAll()
                //The rest of the our application is protected.
                .antMatchers("/**").hasRole("USER")
                //Adds the SocialAuthenticationFilter to Spring Security's filter chain.
                .and()
                .apply(new SpringSocialConfigurer());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Bean
    public SocialUserDetailsService socialUserDetailsService() {
        return new SocialUserDetalServiceImpl(userDetailsService());
    }
}

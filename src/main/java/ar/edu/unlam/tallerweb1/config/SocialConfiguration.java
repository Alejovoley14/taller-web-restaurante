package ar.edu.unlam.tallerweb1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;


import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Sebastian on 01/06/2017.
 */
@Configuration
@EnableSocial
public class SocialConfiguration implements SocialConfigurer {

    @Autowired
    private DataSource dataSource;



    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        connectionFactoryConfigurer.addConnectionFactory(new FacebookConnectionFactory(
                "233668646673605",
                "33b17e044ee6a4fa383f46ec6e28ea1d"));

        connectionFactoryConfigurer.addConnectionFactory(new TwitterConnectionFactory(
                "SNlWrIPkAdp5RVJSQQUmeROv1",
                "3Am8mT3JoNe2IpWYQvmVq7ZVGSusmBCc8vZ2ZPxBlWrXV7TvrQ"));
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {

        return new JdbcUsersConnectionRepository(
                dataSource,
                connectionFactoryLocator,
                Encryptors.noOpText()
        );

    }

    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository connectionRepository) {
        return new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
    }

    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }
}

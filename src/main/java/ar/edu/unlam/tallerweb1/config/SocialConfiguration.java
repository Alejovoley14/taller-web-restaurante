package ar.edu.unlam.tallerweb1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import java.util.List;

/**
 * Created by Sebastian on 01/06/2017.
 */
//@Configuration
//@EnableSocial
public class SocialConfiguration implements SocialConfigurer {

    private List<SocialConfigurer> socialConfigurers;

    @Autowired
    public void setSocialConfigurers(List<SocialConfigurer> socialConfigurers) {
//        Assert.notNull(socialConfigurers, "At least one configuration class must implement SocialConfigurer (or subclass SocialConfigurerAdapter)");
//        Assert.notEmpty(socialConfigurers, "At least one configuration class must implement SocialConfigurer (or subclass SocialConfigurerAdapter)");
        this.socialConfigurers = socialConfigurers;
    }

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        connectionFactoryConfigurer.addConnectionFactory(new FacebookConnectionFactory(
                "233668646673605",
                "33b17e044ee6a4fa383f46ec6e28ea1d"));
    }

    @Override
    public UserIdSource getUserIdSource() {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null) {
                throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
            }
            return authentication.getName();
        };
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {

        UsersConnectionRepository usersConnectionRepository = null;
        for (SocialConfigurer socialConfigurer : socialConfigurers) {
            UsersConnectionRepository ucrCandidate = socialConfigurer.getUsersConnectionRepository(connectionFactoryLocator);
            if (ucrCandidate != null) {
                usersConnectionRepository = ucrCandidate;
                break;
            }
        }
        //Assert.notNull(usersConnectionRepository, "One configuration class must implement getUsersConnectionRepository from SocialConfigurer.");
        return usersConnectionRepository;

    }
}

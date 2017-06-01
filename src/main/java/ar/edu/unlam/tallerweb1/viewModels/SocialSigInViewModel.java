package ar.edu.unlam.tallerweb1.viewModels;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.viewModels.extensions.SocialType;

import java.util.Random;

/**
 * Created by Sebastian on 30/05/2017.
 */
public class SocialSigInViewModel {
    private String id;
    private String email;
    private String accessToken;
    private Long expiresIn;
    private String socialType;

    public Usuario getUsuario(){
        Usuario user = new Usuario();
        user.setEmail(this.email);
        user.setPassword(this.accessToken);
        if(this.socialType.equals("facebook")){
            user.setFacebookAccessToken(this.accessToken);
            user.setFacebookExpiresIn(this.expiresIn);
            user.setFacebookId(this.id);
        }

        return user;
    }

    public String getEmail(){
        return this.email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setSocialType(String socialType) {
        this.socialType = socialType;
    }
}

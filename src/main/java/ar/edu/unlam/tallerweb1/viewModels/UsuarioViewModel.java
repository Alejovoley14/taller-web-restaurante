package ar.edu.unlam.tallerweb1.viewModels;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

/**
 * Created by Sebastian on 28/05/2017.
 */
public class UsuarioViewModel {
    private String email;
    private String password;
    private String verifyPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public Usuario ToUsuario(){
        Usuario usuario = new Usuario();
        usuario.setEmail(this.email);
        usuario.setPassword(this.password);
        return usuario;
    }
}

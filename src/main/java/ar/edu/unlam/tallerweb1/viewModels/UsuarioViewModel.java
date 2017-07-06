/**
 * Created by Sebastian on 28/05/2017.
 */
package ar.edu.unlam.tallerweb1.viewModels;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
public class UsuarioViewModel {
    @NotEmpty(message = "E-Mail es obligatorio")
    @Email(message = "No es un E-Mail valido")
    private String email;
    @Size(min = 6,message = "La contraseña debe tener minimo 6 caracteres")
    @NotEmpty(message = "Contraseña es obligatorio")
    private String password;
    @Size(min = 6,message = "La contraseña debe tener minimo 6 caracteres")
    @NotEmpty(message = "Verificar contraseña es obligatorio")
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

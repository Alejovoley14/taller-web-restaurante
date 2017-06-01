package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Table(name = "usuario")
public class Usuario  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 300)
    private String email;
    @Column(nullable = false,length = 64)
    private String password;
    private String facebookId;
    private String facebookAccessToken;
    private Long facebookExpiresIn;
    private String googleId;
    private String googleAceesToken;
    private String googleRefreshToken;
    @OneToMany(mappedBy = "usuario")
    private Collection<Restaurant> restaurants = new ArrayList<>();
    @OneToMany(mappedBy = "usuario")
    private Collection<Cliente> cliente = new ArrayList<>();

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getFacebookAccessToken() {
        return facebookAccessToken;
    }

    public void setFacebookAccessToken(String facebookAccessToken) {
        this.facebookAccessToken = facebookAccessToken;
    }

    public Long getFacebookExpiresIn() {
        return facebookExpiresIn;
    }

    public void setFacebookExpiresIn(Long facebookExpiresIn) {
        this.facebookExpiresIn = facebookExpiresIn;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getGoogleAceesToken() {
        return googleAceesToken;
    }

    public void setGoogleAceesToken(String googleAceesToken) {
        this.googleAceesToken = googleAceesToken;
    }

    public String getGoogleRefreshToken() {
        return googleRefreshToken;
    }

    public void setGoogleRefreshToken(String googleRefreshToken) {
        this.googleRefreshToken = googleRefreshToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Collection<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Collection<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }


    public Collection<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(Collection<Cliente> cliente) {
        this.cliente = cliente;
    }
}

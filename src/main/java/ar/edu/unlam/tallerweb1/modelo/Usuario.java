package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 300)
    private String email;
    @Column(length = 64)
    private String password;
    private String provider;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "usuario")
    @Fetch(FetchMode.SELECT)
    private Collection<Restaurant> restaurants = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "usuario")
    @Fetch(FetchMode.SELECT)
    private Collection<Cliente> cliente = new ArrayList<>();



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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}

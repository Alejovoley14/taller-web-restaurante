package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sebastian on 04/05/2017.
 */
@Entity(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String nombre;
    @Column(nullable = false, length = 200)
    private String apellido;
    @Column(nullable = false, length = 40)
    private String telefono;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER)
    private Collection<Domicilio> domicilios = new ArrayList<>();

    @ManyToOne(optional = false)
    private Usuario usuario;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(Collection<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }
}

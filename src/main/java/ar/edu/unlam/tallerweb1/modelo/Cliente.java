package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

/**
 * Created by Sebastian on 04/05/2017.
 */
@Entity(name = "Cliente")
public class Cliente extends Entidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 200)
    private String nombre;
    @Column(nullable = false,length = 200)
    private String apellido;
    @Column(nullable = false,length = 40)
    private String telefono;
    @OneToOne(optional = false,mappedBy = "cliente")
    private Domicilio domicilio;
    @OneToOne(optional = false,mappedBy = "cliente")
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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}

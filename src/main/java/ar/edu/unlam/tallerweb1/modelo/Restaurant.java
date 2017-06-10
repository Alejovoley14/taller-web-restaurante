package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sebastian on 04/05/2017.
 */
@Entity(name = "Restaurant")
public class Restaurant  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 300)
    private String razonSocial;
    @Column(nullable = false,length = 300)
    private String nombreFantasia;
    @Column(nullable = false,length = 50)
    private String cuit;
    @OneToMany(mappedBy = "restaurant")
    private Collection<Domicilio> domicilios = new ArrayList<>();
    @ManyToMany
    private Collection<MedioPago> mediosPago = new ArrayList<>();
    @OneToMany(mappedBy = "restaurant")
    private Collection<Mesa> mesas = new ArrayList<>();
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(mappedBy = "restaurant")
    private Collection<Carta> carta = new ArrayList<>();



    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Collection<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(Collection<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "mediopago_restaurant", joinColumns = @JoinColumn(name = "mediopago_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "restaurants_id", referencedColumnName = "id"))
    public Collection<MedioPago> getMediosPago() {
        return mediosPago;
    }

    public void setMediosPago(Collection<MedioPago> mediosPago) {
        this.mediosPago = mediosPago;
    }

    public Collection<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(Collection<Mesa> mesas) {
        this.mesas = mesas;
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

    public Collection<Carta> getCarta() {
        return carta;
    }

    public void setCarta(Collection<Carta> carta) {
        this.carta = carta;
    }
}

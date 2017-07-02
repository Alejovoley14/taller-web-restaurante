package ar.edu.unlam.tallerweb1.modelo;

//import clojure.lang.IFn;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sebastian on 04/05/2017.
 */
@Entity(name = "Carta")
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 200)
    private String titulo;
    @Column(nullable = false,length = 400)
    private String descripcion;
    @Column(nullable = false)
    private Double precio;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @Fetch(FetchMode.SELECT)
    private TipoProducto tipoProducto;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @Fetch(FetchMode.SELECT)
    private Restaurant restaurant;
    @ManyToMany(mappedBy = "carta")
    private Collection<Reserva> reservas = new ArrayList<>();


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Collection<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Collection<Reserva> comensales) {
        this.reservas = reservas;
    }
}

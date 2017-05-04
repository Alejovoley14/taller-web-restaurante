package ar.edu.unlam.tallerweb1.modelo;

import clojure.lang.IFn;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sebastian on 04/05/2017.
 */
@Entity(name = "Carta")
public class Carta extends Entidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 200)
    private String titulo;
    @Column(nullable = false,length = 400)
    private String descripcion;
    @Column(nullable = false)
    private Double precio;
    @ManyToOne(optional = false)
    private TipoProducto tipoProducto;
    @ManyToOne(optional = false)
    private Restaurant restaurant;
    @ManyToMany
    private Collection<Comensal> comensales = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
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

    public Collection<Comensal> getComensales() {
        return comensales;
    }

    public void setComensales(Collection<Comensal> comensales) {
        this.comensales = comensales;
    }
}

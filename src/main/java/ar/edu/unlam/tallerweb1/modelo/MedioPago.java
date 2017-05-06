package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.modelo.extensions.MedioPagoEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sebastian on 04/05/2017.
 */
@Entity(name = "MedioPago")
public class MedioPago extends Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private MedioPagoEnum tipo;
    @Column(nullable = false,length = 200)
    private String descripcion;
    @ManyToMany
    private Collection<Restaurant> restaurants = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public MedioPagoEnum getTipo() {
        return tipo;
    }

    public void setTipo(MedioPagoEnum tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Collection<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}

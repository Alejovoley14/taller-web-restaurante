package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

/**
 * Created by Sebastian on 04/05/2017.
 */
@Entity(name = "Mesa")
public class Mesa extends Entidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer numero;
    @Column(nullable = false)
    private Boolean afuera;
    @ManyToOne(optional = false)
    private Restaurant restaurant;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getAfuera() {
        return afuera;
    }

    public void setAfuera(Boolean afuera) {
        this.afuera = afuera;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
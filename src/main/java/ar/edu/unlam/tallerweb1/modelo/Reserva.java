package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Sebastian on 04/05/2017.
 */
@Entity(name = "Reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false,
            columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date fechaCreacion = new Date();
    @Column(nullable = false)
    private Date fecha;
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name="carta_reserva",joinColumns = {@JoinColumn(name = "reserva_id")},inverseJoinColumns = {@JoinColumn(name = "carta_id")})
    private Collection<Carta> carta = new ArrayList<>();
    private Integer calificacion;
    @ManyToOne(fetch = FetchType.EAGER)
    private MedioPago medioPago;
    @ManyToOne(fetch = FetchType.EAGER)
    private Mesa mesa;
    @Column(nullable = false)
    private Integer cantidadComensales;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Collection<Carta> getCarta() {
        return carta;
    }

    public void setCarta(Collection<Carta> carta) {
        this.carta = carta;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Integer getCantidadComensales() {
        return cantidadComensales;
    }

    public void setCantidadComensales(Integer cantidadComensales) {
        this.cantidadComensales = cantidadComensales;
    }
}

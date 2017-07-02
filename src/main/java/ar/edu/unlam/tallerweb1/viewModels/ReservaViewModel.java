package ar.edu.unlam.tallerweb1.viewModels;

import ar.edu.unlam.tallerweb1.modelo.Carta;
import ar.edu.unlam.tallerweb1.modelo.MedioPago;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

import java.util.Date;
import java.util.List;

/**
 * Created by Sebastian on 02/07/2017.
 */
public class ReservaViewModel {

    private Date fechaCreacion;
    private Date fecha;
    private List<Long> platosSeleccionados;
    private Integer calificacion;
    private Long medioPagoId;
    private Long mesaId;
    private Integer cantidadComensales;

    public Reserva toReserva(MedioPago medioPago, Mesa mesa, List<Carta> platosSeleccionados){
        Reserva reserva = new Reserva();
        reserva.setCantidadComensales(this.cantidadComensales);
        reserva.setFecha(this.fecha);
        reserva.setMedioPago(medioPago);
        reserva.setMesa(mesa);
        reserva.setCarta(platosSeleccionados);
        return reserva;
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

    public List<Long> getPlatosSeleccionados() {
        return platosSeleccionados;
    }

    public void setPlatosSeleccionados(List<Long> platosSeleccionados) {
        this.platosSeleccionados = platosSeleccionados;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Long getMedioPagoId() {
        return medioPagoId;
    }

    public void setMedioPagoId(Long medioPagoId) {
        this.medioPagoId = medioPagoId;
    }

    public Long getMesaId() {
        return mesaId;
    }

    public void setMesaId(Long mesaId) {
        this.mesaId = mesaId;
    }

    public Integer getCantidadComensales() {
        return cantidadComensales;
    }

    public void setCantidadComensales(Integer cantidadComensales) {
        this.cantidadComensales = cantidadComensales;
    }
}

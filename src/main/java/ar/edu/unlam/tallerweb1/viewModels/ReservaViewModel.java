package ar.edu.unlam.tallerweb1.viewModels;

import ar.edu.unlam.tallerweb1.modelo.Carta;
import ar.edu.unlam.tallerweb1.modelo.MedioPago;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by Sebastian on 02/07/2017.
 */
public class ReservaViewModel {

    private Long restaurantId;
    private Date fechaCreacion;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Fecha es obligatorio")
    private Date fecha;
    @NotNull(message = "Debe seleccionar al menos un plato")
    private List<Long> platosSeleccionados;
    private Integer calificacion;
    @NotNull(message = "Medio de pago es obligatorio")
    private Long medioPagoId;
    @NotNull(message = "Mesa es obligatorio")
    private Long mesaId;
    @NotNull(message = "Comensal es obligatorio")
    @Min(value = 1,message = "Debe poner al menos 1 comensal")
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

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}

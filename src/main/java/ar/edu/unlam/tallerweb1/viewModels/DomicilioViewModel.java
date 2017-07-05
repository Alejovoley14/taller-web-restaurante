package ar.edu.unlam.tallerweb1.viewModels;

import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sebastian on 12/06/2017.
 */
public class DomicilioViewModel {

    @NotEmpty(message = "Calle es obligatorio")
    @Size(min = 6,max = 50, message = "Calle debe tener minimo 3 caracteres y maximo 50")
    private String calle;
    @NotNull(message = "Numero es obligatorio")
    private Integer numero;
    @NotNull(message = "Haga click en ubicar en el mapa para obtener la latitud y longitud")
    private Double Latitud;
    private Double Longitud;
    @NotNull(message = "Localidad es obligatorio")
    private Long localidadId;
    private Long provinciaId;
    private Long departamentoId;
    private String localidadDescripcion;
    private String departamentoDescripcion;
    private String provinciaDescripcion;



    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getLatitud() {
        return Latitud;
    }

    public void setLatitud(Double latitud) {
        Latitud = latitud;
    }

    public Double getLongitud() {
        return Longitud;
    }

    public void setLongitud(Double longitud) {
        Longitud = longitud;
    }

    public Long getLocalidadId() {
        return localidadId;
    }

    public void setLocalidadId(Long localidadId) {
        this.localidadId = localidadId;
    }

    public Long getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(Long provinciaId) {
        this.provinciaId = provinciaId;
    }

    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
    }


    public DomicilioViewModel toDomicilioViewmodel(Domicilio domicilio) {
        DomicilioViewModel model = new DomicilioViewModel();
        model.setCalle(domicilio.getCalle());
        model.setNumero(domicilio.getNumero());
        model.setLatitud(domicilio.getLatitud());
        model.setLongitud(domicilio.getLongitud());
        model.setLocalidadId(domicilio.getLocalidad().getId());
        model.setDepartamentoId(domicilio.getLocalidad().getDepartamento().getId());
        model.setProvinciaId(domicilio.getLocalidad().getDepartamento().getProvincia().getId());
        model.setLocalidadDescripcion(domicilio.getLocalidad().getDescripcion());
        model.setDepartamentoDescripcion(domicilio.getLocalidad().getDepartamento().getDescripcion());
        model.setProvinciaDescripcion(domicilio.getLocalidad().getDepartamento().getProvincia().getDescripcion());
        return model;
    }


    public Domicilio toDomicilio(Domicilio domicilio, Localidad localidad) {

        domicilio.setCalle(this.calle);
        domicilio.setNumero(this.numero);
        domicilio.setLatitud(this.Latitud);
        domicilio.setLongitud(this.Longitud);

        domicilio.setLocalidad(localidad);

        return domicilio;
    }

    public String getLocalidadDescripcion() {
        return localidadDescripcion;
    }

    public void setLocalidadDescripcion(String localidadDescripcion) {
        this.localidadDescripcion = localidadDescripcion;
    }

    public String getDepartamentoDescripcion() {
        return departamentoDescripcion;
    }

    public void setDepartamentoDescripcion(String departamentoDescripcion) {
        this.departamentoDescripcion = departamentoDescripcion;
    }

    public String getProvinciaDescripcion() {
        return provinciaDescripcion;
    }

    public void setProvinciaDescripcion(String provinciaDescripcion) {
        this.provinciaDescripcion = provinciaDescripcion;
    }
}

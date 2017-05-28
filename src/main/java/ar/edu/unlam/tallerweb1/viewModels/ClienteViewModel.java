package ar.edu.unlam.tallerweb1.viewModels;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.Localidad;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sebastian on 28/05/2017.
 */
public class ClienteViewModel {

    //Cliente Fields
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;

    //Domicilio Fields
    private String calle;
    private Integer numero;
    private Double Latitud;
    private Double Longitud;
    private Long localidadId;
    private Long provinciaId;
    private Long departamentoId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


    public Cliente toCliente(Cliente cliente) {
        cliente.setApellido(this.apellido);
        cliente.setNombre(this.nombre);
        cliente.setTelefono(this.telefono);



        return cliente;
    }

    public Domicilio toDomicilio(Domicilio domicilio, Localidad localidad){

        domicilio.setCalle(this.calle);
        domicilio.setNumero(this.numero);
        domicilio.setLatitud(this.Latitud);
        domicilio.setLongitud(this.Longitud);

        domicilio.setLocalidad(localidad);

        return domicilio;
    }

    public ClienteViewModel toViewModel(Cliente cliente) {
        ClienteViewModel model = new ClienteViewModel();

        model.setId(cliente.getId());
        model.setApellido(cliente.getApellido());
        model.setNombre(cliente.getNombre());
        model.setTelefono(cliente.getTelefono());

        Domicilio domicilio = cliente.getDomicilios().iterator().next();
        model.setCalle(domicilio.getCalle());
        model.setNumero(domicilio.getNumero());
        model.setLatitud(domicilio.getLatitud());
        model.setLongitud(domicilio.getLongitud());
        model.setLocalidadId(domicilio.getLocalidad().getId());
        model.setDepartamentoId(domicilio.getLocalidad().getDepartamento().getId());
        model.setProvinciaId(domicilio.getLocalidad().getDepartamento().getProvincia().getId());

        return model;
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
}

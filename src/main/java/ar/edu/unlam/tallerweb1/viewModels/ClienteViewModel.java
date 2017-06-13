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

    private DomicilioViewModel domicilio;


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


    public Cliente toCliente(Cliente cliente) {
        cliente.setApellido(this.apellido);
        cliente.setNombre(this.nombre);
        cliente.setTelefono(this.telefono);

        return cliente;
    }


    public ClienteViewModel toViewModel(Cliente cliente) {
        ClienteViewModel model = new ClienteViewModel();

        model.setId(cliente.getId());
        model.setApellido(cliente.getApellido());
        model.setNombre(cliente.getNombre());
        model.setTelefono(cliente.getTelefono());

        Domicilio domicilio = cliente.getDomicilios().iterator().next();
        if (domicilio != null) {
            DomicilioViewModel domicilioViewModel = new DomicilioViewModel();
            model.setDomicilio(domicilioViewModel.toDomicilioViewmodel(domicilio));
        }

        return model;
    }

    public void setDomicilio(DomicilioViewModel domicilio) {
        this.domicilio = domicilio;
    }

    public DomicilioViewModel getDomicilio() {
        return this.domicilio;
    }
}

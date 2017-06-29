package ar.edu.unlam.tallerweb1.viewModels.serializables;

import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

/**
 * Created by spardo on 27/6/2017.
 */
public class RestaurantSerializable {
    private String nombre;
    private String domicilio;
    private Long id;
    private String latLong;

    public RestaurantSerializable(Restaurant restaurant) {
        this.nombre = restaurant.getNombreFantasia();
        Domicilio domicilio = restaurant.getDomicilios().iterator().next();
        this.domicilio = domicilio.getCalle() + " " + domicilio.getNumero() + " " +
                domicilio.getLocalidad().getDescripcion() + ", " +
                domicilio.getLocalidad().getDepartamento().getDescripcion() + ", " +
                domicilio.getLocalidad().getDepartamento().getProvincia().getDescripcion();
        this.id = restaurant.getId();
        this.latLong = domicilio.getLatitud() + "," + domicilio.getLongitud();
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public Long getId(){
        return this.id;
    }

    public String getLatLong(){return this.latLong;}
}

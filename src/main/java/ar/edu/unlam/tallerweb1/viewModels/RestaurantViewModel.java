package ar.edu.unlam.tallerweb1.viewModels;

import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.MedioPago;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


public class RestaurantViewModel {


    private Long id;
    private String razonSocial;
    private String nombreFantasia;
    private String cuit;
    private Long[] medioDePagoIds;

    private DomicilioViewModel domicilio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Long[] getMedioDePagoIds() {
        return medioDePagoIds;
    }

    public void setMedioDePagoIds(Long[] medioDePagoIds) {
        this.medioDePagoIds = medioDePagoIds;
    }

    public void setDomicilio(DomicilioViewModel domicilio) {
        this.domicilio = domicilio;
    }

    public DomicilioViewModel getDomicilio() {
        return domicilio;
    }

    public Restaurant toRestaurant(Restaurant restaurant) {
        restaurant.setRazonSocial(this.razonSocial);
        restaurant.setNombreFantasia(this.nombreFantasia);
        restaurant.setCuit(this.cuit);

        return restaurant;
    }

    public RestaurantViewModel toViewModel(Restaurant restaurant) {
        RestaurantViewModel model = new RestaurantViewModel();

        model.setId(restaurant.getId());
        model.setRazonSocial(restaurant.getRazonSocial());
        model.setNombreFantasia(restaurant.getNombreFantasia());
        model.setCuit(restaurant.getCuit());

        Long[] mediosPagoIds = new Long[restaurant.getMediosPago().size()];
        Collection<Long> ids = new ArrayList<>();
        for (Iterator<MedioPago> it = restaurant.getMediosPago().iterator(); it.hasNext(); ) {
            MedioPago medioPago = it.next();
            ids.add(medioPago.getId());

        }
        ids.toArray(mediosPagoIds);
        model.setMedioDePagoIds(mediosPagoIds);

        Domicilio domicilio = restaurant.getDomicilios().iterator().next();
        if (domicilio != null){
            DomicilioViewModel domicilioViewModel = new DomicilioViewModel();
            model.setDomicilio(domicilioViewModel.toDomicilioViewmodel(domicilio));
        }


        return model;
    }
}

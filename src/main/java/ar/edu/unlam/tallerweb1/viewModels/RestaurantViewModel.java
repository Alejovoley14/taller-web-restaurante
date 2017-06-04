package ar.edu.unlam.tallerweb1.viewModels;

import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;


public class RestaurantViewModel {

	   
	    private Long id;
	    private String razonSocial;
	    private String nombreFantasia;
	    private String cuit;
	   
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
	    
	    public Restaurant toRestaurant(Restaurant restaurant){
	    	restaurant.setRazonSocial(this.razonSocial);
	    	restaurant.setNombreFantasia(this.nombreFantasia);
	    	restaurant.setCuit(this.cuit);
	    	return restaurant;
	    }
	    public Domicilio toDomicilio(Domicilio domicilio, Localidad localidad){

	        domicilio.setCalle(this.calle);
	        domicilio.setNumero(this.numero);
	        domicilio.setLatitud(this.Latitud);
	        domicilio.setLongitud(this.Longitud);

	        domicilio.setLocalidad(localidad);

	        return domicilio;
	    }
	    public RestaurantViewModel toViewModel(Restaurant restaurant) {
	    	RestaurantViewModel model = new RestaurantViewModel();

	        model.setId(restaurant.getId());
	        model.setRazonSocial(restaurant.getRazonSocial());
	        model.setNombreFantasia(restaurant.getNombreFantasia());
	        model.setCuit(restaurant.getCuit());
	        /*
	        Domicilio domicilio = restaurant.getDomicilios().iterator().next();
	        model.setCalle(domicilio.getCalle());
	        model.setNumero(domicilio.getNumero());
	        model.setLatitud(domicilio.getLatitud());
	        model.setLongitud(domicilio.getLongitud());
	        model.setLocalidadId(domicilio.getLocalidad().getId());
	        model.setDepartamentoId(domicilio.getLocalidad().getDepartamento().getId());
	        model.setProvinciaId(domicilio.getLocalidad().getDepartamento().getProvincia().getId());
*/
	        model.setCalle("Islas Malvinas");
	        model.setNumero(1234);
	        model.setLatitud(new Double (0));
	        model.setLongitud(new Double (0));
	        model.setLocalidadId(new Long (1));
	        model.setDepartamentoId(new Long (1));
	        model.setProvinciaId(new Long (1));
	        
	        return model;
	    }
}

package ar.edu.unlam.tallerweb1.viewModels.serializables;

import ar.edu.unlam.tallerweb1.modelo.Mesa;

/**
 * Created by Sebastian on 02/07/2017.
 */
public class MesaSerializable {
    private Long id;
    private Integer numero;
    private String ubicacion;

    public MesaSerializable(Mesa mesa){
        this.id =mesa.getId();
        this.numero = mesa.getNumero();
        this.ubicacion = mesa.getAfuera() ? "Afuera" : "Adentro";
    }

    public Long getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}

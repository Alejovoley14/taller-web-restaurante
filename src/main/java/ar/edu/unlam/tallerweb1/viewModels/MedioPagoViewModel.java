package ar.edu.unlam.tallerweb1.viewModels;

import ar.edu.unlam.tallerweb1.modelo.MedioPago;

/**
 * Created by Sebastian on 02/07/2017.
 */
public class MedioPagoViewModel {
    private Long id;
    private String Descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public MedioPagoViewModel toViemodel(MedioPago medioPago){
        MedioPagoViewModel model = new MedioPagoViewModel();
        model.setDescripcion(medioPago.getDescripcion());
        model.setId(medioPago.getId());
        return model;
    }
}

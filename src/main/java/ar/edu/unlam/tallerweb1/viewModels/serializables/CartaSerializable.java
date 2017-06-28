package ar.edu.unlam.tallerweb1.viewModels.serializables;

import ar.edu.unlam.tallerweb1.modelo.Carta;

/**
 * Created by spardo on 28/6/2017.
 */
public class CartaSerializable {
    private String titulo;
    private String descripcion;
    private String tipo;
    private String precio;

    public CartaSerializable(Carta carta){
        this.descripcion = carta.getDescripcion();
        this.tipo = carta.getTipoProducto().getDescripcion();
        this.precio = carta.getPrecio().toString();
        this.titulo = carta.getTitulo();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPrecio() {
        return precio;
    }

    public String getTitulo() {
        return titulo;
    }
}

package ar.edu.unlam.tallerweb1.viewModels;

import ar.edu.unlam.tallerweb1.modelo.Carta;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.TipoProducto;

/**
 * Created by spardo on 13/6/2017.
 */
public class CartaViewModel {

    private Long id;
    private String titulo;
    private String descripcion;
    private Double precio;
    private Long tipoProductoId;
    private String tipoProducto;
    private Long restaurantId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Long getTipoProductoId() {
        return tipoProductoId;
    }

    public void setTipoProductoId(Long tipoProductoId) {
        this.tipoProductoId = tipoProductoId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Carta toCarta(Carta carta, TipoProducto tipoProducto, Restaurant restaurant) {

        carta.setId(this.id);
        carta.setTitulo(this.titulo);
        carta.setDescripcion(this.descripcion);
        carta.setPrecio(this.precio);
        carta.setTipoProducto(tipoProducto);
        carta.setRestaurant(restaurant);
        return carta;

    }

    public CartaViewModel toViewModel(Carta carta) {
        CartaViewModel model = new CartaViewModel();

        model.setId(carta.getId());
        model.setDescripcion(carta.getDescripcion());
        model.setTitulo(carta.getTitulo());
        model.setPrecio(carta.getPrecio());
        model.setTipoProductoId(carta.getTipoProducto().getId());
        model.setRestaurantId(carta.getRestaurant().getId());
        model.setTipoProducto(carta.getTipoProducto().getDescripcion());

        return model;
    }


    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}

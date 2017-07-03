package ar.edu.unlam.tallerweb1.viewModels;

import ar.edu.unlam.tallerweb1.modelo.Carta;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spardo on 3/7/2017.
 */
public class ReservaRestaurantViewModel {
    private Long id;
    private List<CartaViewModel> platos;
    private String cliente;
    private String mesa;

    public ReservaRestaurantViewModel(Reserva reserva) {
        this.id = reserva.getId();
        this.cliente = reserva.getCliente().getNombre() + " " + reserva.getCliente().getApellido();
        this.mesa = reserva.getMesa().getNumero().toString();
        this.platos = new ArrayList<>();
        for (Carta plato: reserva.getCarta()) {
            CartaViewModel carta = new CartaViewModel();
            this.platos.add(carta.toViewModel(plato));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartaViewModel> getPlatos() {
        return platos;
    }

    public void setPlatos(List<CartaViewModel> platos) {
        this.platos = platos;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }


}

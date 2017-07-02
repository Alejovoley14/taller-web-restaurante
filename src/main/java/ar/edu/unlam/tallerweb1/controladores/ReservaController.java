package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Carta;
import ar.edu.unlam.tallerweb1.modelo.MedioPago;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.servicios.*;
import ar.edu.unlam.tallerweb1.viewModels.ReservaViewModel;
import ar.edu.unlam.tallerweb1.viewModels.RestaurantViewModel;
import ar.edu.unlam.tallerweb1.viewModels.serializables.MesaSerializable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.jws.WebParam;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by spardo on 27/6/2017.
 */
@Controller
public class ReservaController extends BaseController {

    @Inject
    private RestaurantServicio restaurantServicio;
    @Inject
    private ReservaServicio reservaServicio;
    @Inject
    private MedioPagoServicio medioPagoServicio;
    @Inject
    private MesaServicio mesaServicio;
    @Inject
    private CartaServicio cartaServicio;

    @RequestMapping(value = "/reserva/{restaurantId}", method = RequestMethod.GET)
    public ModelAndView iniciarReserva(@PathVariable(value = "restaurantId") Long restaurantId) {
        ModelMap model = new ModelMap();
        RestaurantViewModel viewModel = new RestaurantViewModel();
        Restaurant restaurant = restaurantServicio.get(restaurantId);
        model.put("restaurant", viewModel.toViewModelWithcarta(restaurant));
        return new ModelAndView("reserva/index", model);
    }

    @RequestMapping(value = "/reserva/confirmar", method = RequestMethod.POST)
    public ModelAndView confirmarReserva(@ModelAttribute ReservaViewModel model) {
        Mesa mesa = mesaServicio.getMesa(model.getMesaId());
        MedioPago medioPago = medioPagoServicio.get(model.getMedioPagoId());
        List<Carta> platosSeleccionados = cartaServicio.getCartas(model.getPlatosSeleccionados());
        reservaServicio.save(model.toReserva(medioPago, mesa, platosSeleccionados));

        return new ModelAndView("redirect:/reserva/confirmada");
    }

    @RequestMapping(value = "/reserva/confirmada")
    public ModelAndView reservaConfirmada() {
        return new ModelAndView("reserva/confirmada");
    }

    @RequestMapping(value = "/reserva/mesas/{restaurantId}/{fecha}", method = RequestMethod.GET)
    public List<MesaSerializable> getMesas(@PathVariable(value = "restaurantId") Long restaurantId, @PathVariable(value = "fecha") Date fecha) {
        List<Mesa> mesas = reservaServicio.getMesasDisponibles(fecha, restaurantId);
        List<MesaSerializable> mesasDisponibles = new ArrayList<>();
        for (Mesa mesa : mesas) {
            mesasDisponibles.add(new MesaSerializable(mesa));
        }
        return mesasDisponibles;
    }

}

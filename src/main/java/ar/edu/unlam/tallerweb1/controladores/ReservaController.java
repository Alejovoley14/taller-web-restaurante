package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import ar.edu.unlam.tallerweb1.viewModels.ConfirmarCancelarViewModel;
import ar.edu.unlam.tallerweb1.viewModels.ReservaRestaurantViewModel;
import ar.edu.unlam.tallerweb1.viewModels.ReservaViewModel;
import ar.edu.unlam.tallerweb1.viewModels.RestaurantViewModel;
import ar.edu.unlam.tallerweb1.viewModels.serializables.MesaSerializable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView iniciarReserva(Principal principal, @PathVariable(value = "restaurantId") Long restaurantId) {
        ModelMap model = new ModelMap();

        if(getCurrentUser(principal).getCliente() == null){
            return new ModelAndView("redirect:/cliente");
        }

        RestaurantViewModel viewModel = new RestaurantViewModel();
        Restaurant restaurant = restaurantServicio.get(restaurantId);
        model.put("restaurant", viewModel.toViewModelWithcarta(restaurant));
        return new ModelAndView("reserva/index", model);
    }

    @RequestMapping(value = "/reserva/confirmar", method = RequestMethod.POST)
    public ModelAndView confirmarReserva(Principal principal, @ModelAttribute ReservaViewModel model) {
        Mesa mesa = mesaServicio.getMesa(model.getMesaId());
        MedioPago medioPago = medioPagoServicio.get(model.getMedioPagoId());

        List<Carta> platosSeleccionados = new ArrayList<>();

        for (Long id : model.getPlatosSeleccionados()) {
            platosSeleccionados.add(cartaServicio.get(id));
        }

        Reserva reserva = model.toReserva(medioPago, mesa, platosSeleccionados);
        reserva.setCliente(getCurrentUser(principal).getCliente().iterator().next());
        reservaServicio.save(reserva);

        ModelMap returnModel = new ModelMap();
        returnModel.put("reserva", reserva);
        return new ModelAndView("reserva/confirmada", returnModel);
    }


    @RequestMapping(value = "/reserva/mesas/{restaurantId}/{fecha}", method = RequestMethod.GET)
    @ResponseBody
    public List<MesaSerializable> getMesas(@PathVariable(value = "restaurantId") Long restaurantId, @PathVariable(value = "fecha") @DateTimeFormat(pattern = "ddMMyyyy") Date fecha) {
        List<Mesa> mesas = reservaServicio.getMesasDisponibles(fecha, restaurantId);
        List<MesaSerializable> mesasDisponibles = new ArrayList<>();
        for (Mesa mesa : mesas) {
            mesasDisponibles.add(new MesaSerializable(mesa));
        }
        return mesasDisponibles;
    }

    @RequestMapping(value = "/reserva/restaurant/confirmar",method = RequestMethod.POST)
    public ModelAndView confirmarReserva(@ModelAttribute ConfirmarCancelarViewModel model){
        Reserva reserva = reservaServicio.get(model.getId());
        reserva.setAsistencia(true);
        reservaServicio.save(reserva);
        return new ModelAndView("redirect:/reserva/restaurant");
    }

    @RequestMapping(value = "/reserva/restaurant/cancelar",method = RequestMethod.POST)
    public ModelAndView cancelarReserva(@ModelAttribute ConfirmarCancelarViewModel model){
        Reserva reserva = reservaServicio.get(model.getId());
        reserva.setAsistencia(false);
        reservaServicio.save(reserva);
        return new ModelAndView("redirect:/reserva/restaurant");
    }


    @RequestMapping(value = "/reserva/restaurant")
    public ModelAndView getMisReservas(Principal principal) {
        List<Restaurant> restaurants = restaurantServicio.getAll(getCurrentUser(principal).getId());
        ModelMap model = new ModelMap();
        List<ReservaRestaurantViewModel> reservasViewModel = new ArrayList<>();
        for (Reserva reserva: reservaServicio.reservasRestaurants(restaurants)) {
            reservasViewModel.add(new ReservaRestaurantViewModel(reserva));
        }

        model.put("reservas", reservasViewModel);
        return new ModelAndView("reserva/listarestaurant",model);

    }

}

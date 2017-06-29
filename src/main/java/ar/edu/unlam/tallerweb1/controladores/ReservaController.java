package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.RestaurantServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.security.Principal;

/**
 * Created by spardo on 27/6/2017.
 */
@Controller
public class ReservaController extends BaseController {

    @Inject
    private RestaurantServicio restaurantServicio;

    @RequestMapping(value = "/reserva/{restaurantId}", method = RequestMethod.GET)
    public ModelAndView iniciarReserva(Principal principal,@PathVariable(value = "restaurantId") Long restaurantId) {
        ModelMap model = new ModelMap();
        model.put("restaurant", restaurantServicio.get(restaurantId));
        return new ModelAndView("reserva/index", model);
    }

}

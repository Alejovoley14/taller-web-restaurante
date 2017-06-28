package ar.edu.unlam.tallerweb1.controladores;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.CartaServicio;
import ar.edu.unlam.tallerweb1.servicios.RestaurantServicio;
import ar.edu.unlam.tallerweb1.servicios.TipoProductoServicio;
import ar.edu.unlam.tallerweb1.viewModels.CartaViewModel;
import ar.edu.unlam.tallerweb1.viewModels.serializables.CartaSerializable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Carta;
import ar.edu.unlam.tallerweb1.modelo.TipoProducto;

import javax.inject.Inject;
import javax.jws.WebParam;


@Controller
public class CartaController extends BaseController {

    @Inject
    private CartaServicio cartaServicio;
    @Inject
    private TipoProductoServicio tipoProductoServicio;
    @Inject
    private RestaurantServicio restaurantServicio;

    @RequestMapping("/carta/{restaurantId}")
    public ModelAndView getCarta(Principal principal, @PathVariable("restaurantId") Long restaurantId) {

        ModelMap modelo = new ModelMap();
        Usuario user = getCurrentUser(principal);
        modelo.put("cartas", cartaServicio.getAll(restaurantId, user.getId()));
        modelo.put("restaurant",restaurantServicio.get(restaurantId));
        return new ModelAndView("carta/index", modelo);
    }

    @RequestMapping(path = "/carta/create/{restaurantId}", method = RequestMethod.GET)
    public ModelAndView createCarta(@PathVariable("restaurantId") Long restaurantId) {

        //todo: validar restaurant pertenece a usuario, sino redirigir a not found

        ModelMap model = new ModelMap();
        CartaViewModel viewModel = new CartaViewModel();
        viewModel.setRestaurantId(restaurantId);
        model.put("carta", viewModel);
        model.put("restaurant",restaurantServicio.get(restaurantId));
        model.put("tiposProducto", tipoProductoServicio.getAllOrderByNombre());

        return new ModelAndView("carta/create", model);
    }

    @RequestMapping(path = "/carta/add", method = RequestMethod.POST)
    public ModelAndView addCarta(@ModelAttribute("carta") CartaViewModel model) {

        //todo: validar viewModel y devolver vista con errores, validar restaurant pertenece a usuario sino redirigir a not found

        Restaurant restaurant = restaurantServicio.get(model.getRestaurantId());
        TipoProducto tipoProducto = tipoProductoServicio.get(model.getTipoProductoId());

        cartaServicio.create(model.toCarta(new Carta(), tipoProducto, restaurant));

        return new ModelAndView("redirect:/carta/" + model.getRestaurantId());
    }

    //editar menu
    @RequestMapping(path = "/carta/edit/{cartaId}", method = RequestMethod.GET)
    public ModelAndView editarMenu(@PathVariable("cartaId") Long cartaId) {

        //todo: validar restaurant pertenece a usuario, sino redirigir a not found

        ModelMap model = new ModelMap();

        Carta carta = cartaServicio.get(cartaId);
        CartaViewModel viewModel = new CartaViewModel();

        model.put("carta", viewModel.toViewModel(carta));
        model.put("restaurant",restaurantServicio.get(carta.getRestaurant().getId()));
        model.put("tiposProducto", tipoProductoServicio.getAllOrderByNombre());

        return new ModelAndView("carta/edit", model);

    }


    @RequestMapping(path = "/carta/update", method = RequestMethod.POST)
    public ModelAndView updateCarta(@ModelAttribute("carta") CartaViewModel model) {

        //todo: validar viewModel y devolver vista con errores, validar restaurant pertenece a usuario sino redirigir a not found

        Restaurant restaurant = restaurantServicio.get(model.getRestaurantId());
        TipoProducto tipoProducto = tipoProductoServicio.get(model.getTipoProductoId());
        Carta carta = cartaServicio.get(model.getId());
        cartaServicio.update(model.toCarta(carta, tipoProducto, restaurant));

        return new ModelAndView("redirect:/carta/" + model.getRestaurantId());
    }

    @RequestMapping(value = "/carta/restaurant/{restaurantId}")
    @ResponseBody
    public List<CartaSerializable> getCartaForRestaurant(@PathVariable(value = "restaurantId")Long restaurantId){
        List<Carta> cartas = cartaServicio.getAll(restaurantId);
        List<CartaSerializable> cartasSerializable = new ArrayList<>();
        for (Carta carta: cartas) {
            cartasSerializable.add(new CartaSerializable(carta));
        }

        return cartasSerializable;
    }
    //eliminar menu
//    @RequestMapping(path = "/eliminar-menu", method = RequestMethod.POST)
//    public ModelAndView eliminarMenu(@ModelAttribute("carta") Carta carta) {
//
//        ModelMap model = new ModelMap();
//        model.put("carta", carta);
//        ArrayList<Carta> c = new ArrayList<Carta>();
//
//        for (Integer i = 0; i < c.size(); i++) {
//            TipoProducto tipoProducto = new TipoProducto();
//            tipoProducto.setId(Long.parseLong("1"));
//            tipoProducto.setDescripcion("descripción");
//            carta.setTipoProducto(tipoProducto);
//            c.remove(carta);
//        }
//        return new ModelAndView("carta", model);
//
//    }


} 



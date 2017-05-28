package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.servicios.LocalidadServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Sebastian on 28/05/2017.
 */
@Controller
public class LocalidadController {
    @Inject
    private LocalidadServicio localidadServicio;

    @RequestMapping(value = "/localidad/{departamentoId}/all",method = RequestMethod.GET)
    @ResponseBody
    public List<Localidad> getLocalidadByDepartamento(@PathVariable("departamentoId") Long departamentoId){
        return localidadServicio.getAllByDepartamentoId(departamentoId);
    }
}

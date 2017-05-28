package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.servicios.ProvinciaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Sebastian on 28/05/2017.
 */
@Controller
public class ProvinciaController {

    @Inject
    private ProvinciaServicio provinciaServicio;

    @RequestMapping(value = "/provincia/all",method = RequestMethod.GET)
    @ResponseBody
    public List<Provincia> getProvincias(){
        return provinciaServicio.getAll();
    }

}

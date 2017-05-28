package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Departamento;
import ar.edu.unlam.tallerweb1.servicios.DepartamentoServicio;
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
public class DepartamentoController {

    @Inject
    DepartamentoServicio departamentoServicio;

    @RequestMapping(value = "/departamento/{provinciaId}/all",method = RequestMethod.GET)
    @ResponseBody
    public List<Departamento> getDepartamentosByProvincia(@PathVariable("provinciaId") Long provinciaId){
        return departamentoServicio.getAllByProvinciaId(provinciaId);
    }
}

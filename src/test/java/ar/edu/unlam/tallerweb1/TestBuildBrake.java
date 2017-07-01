package ar.edu.unlam.tallerweb1;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
/**
 * Created by Sebastian on 01/07/2017.
 */

public class TestBuildBrake {

    @Test
    public void romperTest(){

        assertThat(true).isEqualTo(false);
    }
}


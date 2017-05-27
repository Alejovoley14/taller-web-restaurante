package ar.edu.unlam.tallerweb1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Sebastian on 13/05/2017.
 */
@Configuration
@ComponentScan({"ar.edu.unlam.tallerweb1.dao","ar.edu.unlam.tallerweb1.controladores","ar.edu.unlam.tallerweb1.servicios","ar.edu.unlam.tallerweb1.config"})
//@ImportResource("classpath:hibernateContext.xml")
public class RootConfiguration {
}

package ar.edu.unlam.tallerweb1.config;

import ar.edu.unlam.tallerweb1.interceptors.CheckClienteInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Sebastian on 14/05/2017.
 */
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public CheckClienteInterceptor checkClienteInterceptor() {
        return new CheckClienteInterceptor();
    }

//    @Override
//    public  void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(checkClienteInterceptor()).addPathPatterns("/reserva/*");
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/css/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/js/");
        registry.addResourceHandler("/fonts/**")
                .addResourceLocations("/fonts/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void configureDefaultServletHandling( DefaultServletHandlerConfigurer configurer ){
        configurer.enable();
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/vistas/");
        viewResolver.setSuffix(".jsp");



        return viewResolver;
    }
}

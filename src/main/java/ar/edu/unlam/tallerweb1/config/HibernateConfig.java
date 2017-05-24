package ar.edu.unlam.tallerweb1.config;

import ar.edu.unlam.tallerweb1.dao.BaseDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDaoImpl;
import ar.edu.unlam.tallerweb1.modelo.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import javax.sql.DataSource;

/**
 * Created by Sebastian on 14/05/2017.
 */
@Configuration
@EnableTransactionManagement
public class HibernateConfig {



    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setAnnotatedClasses(Usuario.class);
        sessionFactory.setAnnotatedClasses(Carta.class);
        sessionFactory.setAnnotatedClasses(Cliente.class);
        sessionFactory.setAnnotatedClasses(Comensal.class);
        sessionFactory.setAnnotatedClasses(Departamento.class);
        sessionFactory.setAnnotatedClasses(Domicilio.class);
        sessionFactory.setAnnotatedClasses(Localidad.class);
        sessionFactory.setAnnotatedClasses(MedioPago.class);
        sessionFactory.setAnnotatedClasses(Mesa.class);
        sessionFactory.setAnnotatedClasses(Persona.class);
        sessionFactory.setAnnotatedClasses(Provincia.class);
        sessionFactory.setAnnotatedClasses(Reserva.class);
        sessionFactory.setAnnotatedClasses(Restaurant.class);
        sessionFactory.setAnnotatedClasses(TipoProducto.class);


        //sessionFactory.setPackagesToScan(new String[] {"ar.edu.unlam.tallerWeb1.modelo"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",      "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.validator.apply_to_ddl","false");
        properties.put("hibernate.validator.autoregister_listeners","false");
        properties.put("hibernate.format_sql","false");
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db");
        dataSource.setUsername("root");
        dataSource.setPassword("P@55w0rd");
        return dataSource;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new   HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }



}

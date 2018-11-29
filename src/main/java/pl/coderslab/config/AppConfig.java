package pl.coderslab.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.converter.*;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;
import java.util.Locale;

//import pl.coderslab.converter.AuthorConverter;

@Configuration
@EnableWebMvc
@EnableJpaRepositories(basePackages = "pl.coderslab")
@ComponentScan(basePackages = "pl.coderslab")
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("persistenceUnit");
        return emfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager tm = new JpaTransactionManager(emf);
        return tm;
    }

    @Bean(name = "localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pl", "PL"));
        return localeResolver;
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public StringTabToGroupConverter convertSTTG() {
        return new StringTabToGroupConverter();
    }

    @Bean
    public StringToGroupsConverter convertSTGs() {
        return new StringToGroupsConverter();
    }

    @Bean
    public StringTabToTrainingDayConverter convertSTTTD() {
        return new StringTabToTrainingDayConverter();
    }

    @Bean
    public StringToTrainingDayConverter convertSTTD() {
        return new StringToTrainingDayConverter();
    }

    @Bean
    public StringToGroupConverter convertSTG() {
        return new StringToGroupConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(convertSTTG());
        registry.addConverter(convertSTG());
        registry.addConverter(convertSTGs());
        registry.addConverter(convertSTTTD());
        registry.addConverter(convertSTTD());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
    }
}
package com.Encommerce;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author cesar
 */
//Servira para controlar las rutas relativas de las imagenes y asi poder usarlas en la home
@Configuration
public class ResoruceWebConfiguration implements WebMvcConfigurer {
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        
        registry.addResourceHandler("/imagenes/**").addResourceLocations("file:imagenes//");
    }
    
}

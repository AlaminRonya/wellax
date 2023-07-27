package com.attrabit.wellax.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class ThymeleafConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO: 27/07/2023 css file  configuration
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");
        // TODO: 27/07/2023 images file  configuration
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/");
        // TODO: 27/07/2023 js file  configuration
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");

    }
}

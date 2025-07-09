package com.cefet.ds_guia12.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/imagens/**") // URL acessível
          .addResourceLocations("file:///d:/uploads/"); // caminho real (precisa das 3 barras)
    }
}
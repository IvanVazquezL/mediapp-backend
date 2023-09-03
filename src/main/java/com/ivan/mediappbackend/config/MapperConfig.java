package com.ivan.mediappbackend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    // JavaBeans are a reusable software component and are used to encapsulate and manage data, making
    // them suitable for representing objects in Java applications
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

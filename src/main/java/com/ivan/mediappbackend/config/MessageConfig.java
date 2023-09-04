package com.ivan.mediappbackend.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class MessageConfig {
    // Bean -> instances handled by Spring
    @Bean
    // Load of properties
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // It will search all the properties with the name messages
        messageSource.setBasename("classpath:messages");
        return messageSource;
    }

    // TO establish a locale default
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        //Set the locale base
        slr.setDefaultLocale(Locale.ROOT);
        return slr;
    }

    // To make the messages match the language
    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        // Indicates the source of the properties
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}

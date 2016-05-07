package com.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * Created by arahansa on 2016-04-02.
 */

@Configuration
@ComponentScan(basePackages = {
        "com.example.common.controller",
        "com.example.security.controller",
        "com.example.user.controller"
})
@EnableWebMvc
public class WebMvcConfig  extends WebMvcConfigurerAdapter {
    private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/views/";
    private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // http://stackoverflow.com/questions/29394493/spring-mvc-configuration-enable
        // <mvc:default-servlet-handler/>
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
        viewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);
        return viewResolver;
    }

    // JSON Converter Config
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(messageConverter());
    }

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

    @Bean
    public MappingJackson2HttpMessageConverter messageConverter(){
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setObjectMapper(objectMapper());
        return messageConverter;
    }


    @Autowired
    private UsersConnectionRepository usersConnectionRepository;
    @Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;

    @Bean
    public ProviderSignInUtils providerSignInUtils(){
        ProviderSignInUtils providerSignInUtils =
                new ProviderSignInUtils(connectionFactoryLocator, usersConnectionRepository);
        return providerSignInUtils;
    }


}

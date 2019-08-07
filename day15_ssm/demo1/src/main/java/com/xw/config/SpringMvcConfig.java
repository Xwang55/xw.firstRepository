package com.xw.config;

import com.xw.interceptor.MyFirstInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.stereotype.Controller;
import com.xw.converter.String2DateConverter;

import javax.annotation.PostConstruct;

@EnableWebMvc
@ComponentScan(value = "com.xw.controller",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class))

    //实现WebMvcConfig接口
    public class SpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    ConfigurableConversionService conversionService;

    //日期转换
    @PostConstruct
    public void addConverters(){
        String2DateConverter string2DateConverter = new String2DateConverter();
        conversionService.addConverter(string2DateConverter);
    }

    @Bean
    @Primary
    public ConfigurableConversionService configurableConversionService(){
        return conversionService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyFirstInterceptor());
        //registry.addInterceptor().addPathPatterns("/abc/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pic/**").addResourceLocations("file:D:/pic/");
        registry.addResourceHandler("/pic/**").addResourceLocations("classpath:/pic/");
        registry.addResourceHandler("/pic/**").addResourceLocations("/WEB-INF/pic");
    }
}

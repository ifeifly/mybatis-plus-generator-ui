package com.github.davidfantasy.mybatisplus.generatorui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


/**
 * 不使用@SpringBootApplication和@EnableAutoConfiguration
 * 注解，避免启动时被宿主系统的自动配置所干扰，直接注入需要的配置类
 */
@SpringBootConfiguration
@Import({
        DispatcherServletAutoConfiguration.class,
        ServletWebServerFactoryAutoConfiguration.class,
        HttpEncodingAutoConfiguration.class,
        HttpMessageConvertersAutoConfiguration.class,
        MultipartAutoConfiguration.class,
        ErrorMvcAutoConfiguration.class,
        WebMvcAutoConfiguration.class})
@ComponentScan("com.github.davidfantasy.mybatisplus.generatorui")
@Slf4j
public class MybatisPlusToolsApplication {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerConfig(GeneratorConfig generatorConfig) {
        return factory -> {
            if (generatorConfig.getPort() != null) {
                factory.setPort(generatorConfig.getPort());
            } else {
                factory.setPort(8080);
            }
            factory.setContextPath("");
        };
    }

//    @Bean
//    public GeneratorConfig generatorConfig() {
//        // This bean will be overridden by the bean defined in GeneratorApplication
//        return new GeneratorConfig();
//    }


}


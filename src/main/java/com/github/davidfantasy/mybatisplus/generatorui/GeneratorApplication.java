package com.github.davidfantasy.mybatisplus.generatorui;

import com.github.davidfantasy.mybatisplus.generatorui.configurer.GeneratorProperties;
import com.github.davidfantasy.mybatisplus.generatorui.mbp.NameConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Fly
 * @Date 2025/2/21 下午3:09
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class GeneratorApplication extends SpringBootServletInitializer {

    @Resource
    GeneratorProperties generatorProperties;

    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GeneratorApplication.class);
    }

    @Bean
    public GeneratorConfig buildGeneratorConfig() {
        GeneratorConfig config = GeneratorConfig.builder()
                .jdbcUrl(generatorProperties.getJdbcUrl())
                .userName(generatorProperties.getUserName())
                .password(generatorProperties.getPassword())
                .port(generatorProperties.getPort())
                .driverClassName(generatorProperties.getDriverClassName())
                .basePackage(generatorProperties.getBasePackage())
                .tablePrefix(generatorProperties.getTablePrefix())
                .nameConverter(new NameConverter() {
                    @Override
                    public String serviceNameConvert(String entityName) {
                        return entityName + "Service";
                    }

                    @Override
                    public String controllerNameConvert(String entityName) {
                        return entityName + "Action";
                    }
                })
                .build();
        return config;
    }
}

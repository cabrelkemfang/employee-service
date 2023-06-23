package io.growtogether.com.employeeservice.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class WebClientConfig {
    @Bean
    @ConditionalOnMissingBean(BuildProperties.class)
    BuildProperties buildProperties() {
        return new BuildProperties(new Properties());
    }
}

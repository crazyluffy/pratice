package org.renm.configLoad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {


    @Bean("innerConfigSource")
    public ConfigSource innerConfigSource() {
        return new ConfigSource();
    }

    @Bean(name = "configLoader")
    public ConfigLoader configLoader() {
        return new ConfigLoader(innerConfigSource());
    }
}

package com.cl.idesoft.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.support.DefaultServerCodecConfigurer;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {
    @Override
    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
        if (configurer instanceof DefaultServerCodecConfigurer) {
            configurer.defaultCodecs()
                    .jackson2JsonDecoder(new CustomJackson2JsonDecoder());
        }
    }
}

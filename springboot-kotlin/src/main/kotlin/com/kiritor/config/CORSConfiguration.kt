package com.kiritor.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class CORSConfiguration:WebMvcConfigurerAdapter() {
    override fun addCorsMappings(registry: CorsRegistry) {
        super.addCorsMappings(registry)
        registry.addMapping("/**").allowedHeaders("*").allowedMethods("*").allowedOrigins("*")

    }
}
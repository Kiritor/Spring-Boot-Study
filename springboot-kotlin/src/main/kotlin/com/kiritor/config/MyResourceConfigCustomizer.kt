package com.kiritor.config

import com.kiritor.api.ItemAPI
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.boot.autoconfigure.jersey.ResourceConfigCustomizer
import org.springframework.stereotype.Component

class MyResourceConfigCustomizer: ResourceConfigCustomizer {
    override fun customize(config: ResourceConfig) {
        config.register(ItemAPI::class.java)
    }
}
package com.kiritor.config

import com.kiritor.api.ItemAPI
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component
import javax.ws.rs.ApplicationPath

@Component
@ApplicationPath("api")
class JersyConfig:ResourceConfig() {
    override fun register(component: Any?): ResourceConfig {
        return super.register(ItemAPI::class.java)
    }
}

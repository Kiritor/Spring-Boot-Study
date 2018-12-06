package com.kiritor.api

import com.kiritor.entity.Item
import com.kiritor.service.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Component
@Path(value = "/item")
class ItemAPI {

    @Autowired
    lateinit var itemService: ItemService

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun getItemList():List<Item> {
        return itemService.getItemList()
    }
}
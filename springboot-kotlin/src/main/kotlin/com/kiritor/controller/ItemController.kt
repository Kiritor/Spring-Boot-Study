package com.kiritor.controller

import com.kiritor.entity.Item
import com.kiritor.service.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value= "/items")
class ItemController {
    @Autowired
    lateinit var itemService: ItemService


    @RequestMapping(value = "/", method = arrayOf(RequestMethod.GET))
    fun index(): List<Item> {
        return itemService.getItemList();
    }

    @RequestMapping(value = "/update", method = arrayOf(RequestMethod.POST))
    fun update(@RequestBody items:List<Item>): List<Item> {
        return itemService.update(items)
    }

    @RequestMapping(value = "/delete", method = arrayOf(RequestMethod.POST))
    fun delete(@RequestBody item:Item) {
        itemService.delete(item)
    }
}
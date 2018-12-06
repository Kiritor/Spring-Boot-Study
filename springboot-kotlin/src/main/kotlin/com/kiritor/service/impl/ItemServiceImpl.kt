package com.kiritor.service.impl

import com.kiritor.entity.Item
import com.kiritor.repository.ItemRepository
import com.kiritor.service.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ItemServiceImpl:ItemService {


    @Autowired
    lateinit var itemRepository: ItemRepository

    override fun getItemList(): List<Item> {
        return itemRepository.findAll();
    }

    override fun update(items: List<Item>): List<Item> {
        itemRepository.deleteAll()
        itemRepository.saveAll(items)
        return items
    }

    override fun delete(item: Item) {
        itemRepository.delete(item)
    }

}
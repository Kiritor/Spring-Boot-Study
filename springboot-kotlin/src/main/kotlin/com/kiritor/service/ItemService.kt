package com.kiritor.service

import com.kiritor.entity.Item

interface ItemService {
    fun getItemList():List<Item>
    fun update(items:List<Item>):List<Item>
    fun delete(item:Item)
}
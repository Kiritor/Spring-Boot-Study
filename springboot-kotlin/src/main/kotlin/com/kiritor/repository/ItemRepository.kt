package com.kiritor.repository

import com.kiritor.entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import java.io.Serializable

interface ItemRepository: JpaRepository<Item, Long>,
        Serializable {
}
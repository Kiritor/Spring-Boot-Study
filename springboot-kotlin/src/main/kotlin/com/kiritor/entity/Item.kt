package com.kiritor.entity

import java.io.Serializable
import javax.persistence.*


@Entity
@Table(name = "T_ITEM")
data class Item(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @Column(name = "title")
        var title: String? = null,

        @Column(name = "completed")
        var completed: Boolean? = null,

        @Column(name = "edited")
        var edited: Boolean? = null
): Serializable
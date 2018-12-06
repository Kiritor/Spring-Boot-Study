package com.kiritor.entity

import java.io.Serializable
import javax.persistence.*


@Entity
@Table(name = "T_USER")
data class User(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @Column(name = "user_name")
        var userName: String? = null,

        @Column(name = "password")
        var password: String? = null,
        @Column(name = "tel_phone")
        var telPhone: String? = null
):Serializable
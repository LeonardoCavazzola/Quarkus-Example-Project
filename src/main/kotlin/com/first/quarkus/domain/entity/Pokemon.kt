package com.first.quarkus.domain.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
class Pokemon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: BigDecimal,

    @ElementCollection
    val type: Set<String>,
)

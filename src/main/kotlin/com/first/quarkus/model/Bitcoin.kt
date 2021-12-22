package com.first.quarkus.model

import java.math.BigDecimal
import java.time.LocalDate

class Bitcoin(
    val id: Long,
    val value: BigDecimal,
    val type: String,
    val date: LocalDate,
)

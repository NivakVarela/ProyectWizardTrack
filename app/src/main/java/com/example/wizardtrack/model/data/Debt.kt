package com.example.wizardtrack.model.data


import java.math.BigDecimal
import kotlinx.datetime.LocalDateTime


data class Debt(
    var id: Long = 0,
    var idUser: Long = 0,
    var amount: BigDecimal = BigDecimal.ZERO,
    var starDate: String  = "2000-01-01T00:00:00",
    var endDate: String  = "2000-01-01T00:00:00",
    var interest: BigDecimal = BigDecimal.ZERO,
    var description: String? = null,
    var name: String = "",
    var installments: Byte = 0,
    var idUserNavigation: UserWizardtrack? = null // Ajusta el tipo de acuerdo a tu implementación en Kotlin
)

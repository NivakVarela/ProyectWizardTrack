package com.example.wizardtrack.model.data

import java.math.BigDecimal
import org.threeten.bp.LocalDateTime


data class Debt(
    var id: Long = 0,
    var idUser: Long = 0,
    var amount: BigDecimal = BigDecimal.ZERO,
    var starDate: LocalDateTime = LocalDateTime.MIN
    var endDate: LocalDateTime = LocalDateTime.MIN,
    var interest: BigDecimal = BigDecimal.ZERO,
    var description: String? = null,
    var name: String = "",
    var installments: Byte = 0,
    var idUserNavigation: UserWizardtrack? = null // Ajusta el tipo de acuerdo a tu implementación en Kotlin
)

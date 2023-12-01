package com.example.wizardtrack.model.data


import java.math.BigDecimal
import org.threeten.bp.LocalDateTime

data class Income(
    var id: Long = 0,
    var idUser: Long = 0,
    var amount: BigDecimal = BigDecimal.ZERO,
    var frequency: Byte = 0,
    var incomeDate: LocalDateTime = LocalDateTime.MIN,
    var description: String = "",
    var name: String = "",
    var idUserNavigation: UserWizardtrack? = null
)

package com.example.wizardtrack.model.data


import org.threeten.bp.LocalDateTime
import java.math.BigDecimal


data class SaveCount(
    var id: Long = 0,
    var idUser: Long = 0,
    var amount: BigDecimal = BigDecimal.ZERO,
    var starDate: LocalDateTime = LocalDateTime.MIN,
    var endDate: LocalDateTime = LocalDateTime.MIN,
    var description: String? = null,
    var name: String = "",
    var idUserNavigation: UserWizardtrack? = null
)

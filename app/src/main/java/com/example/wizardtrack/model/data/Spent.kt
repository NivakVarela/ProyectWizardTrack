package com.example.wizardtrack.model.data

import org.threeten.bp.LocalDateTime
import java.math.BigDecimal

data class Spent(
    var id: Long = 0,
    var idUser: Long = 0,
    var amount: BigDecimal = BigDecimal.ZERO,
    var count: Long = 0,
    var spentDate: LocalDateTime = LocalDateTime.MIN,
    var description: String? = null,
    var name: String = "",
    var idUserNavigation: UserWizardtrack? = null
)
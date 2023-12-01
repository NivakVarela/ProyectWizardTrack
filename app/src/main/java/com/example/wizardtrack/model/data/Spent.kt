package com.example.wizardtrack.model.data

import java.math.BigDecimal

data class Spent(
    var id: Long = 0,
    var idUser: Long = 0,
    var amount: BigDecimal = BigDecimal.ZERO,
    var count: Long = 0,
    var spentDate: String  = "2000-01-01T00:00:00",
    var description: String? = null,
    var name: String = "",
    var idUserNavigation: UserWizardtrack? = null
)
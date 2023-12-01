package com.example.wizardtrack.model.data


import java.math.BigDecimal

data class Income(
    var id: Long = 0,
    var idUser: Long = 0,
    var amount: BigDecimal = BigDecimal.ZERO,
    var frequency: Byte = 0,
    var incomeDate: String  = "2000-01-01T00:00:00",
    var description: String = "",
    var name: String = "",
    var idUserNavigation: UserWizardtrack? = null
)

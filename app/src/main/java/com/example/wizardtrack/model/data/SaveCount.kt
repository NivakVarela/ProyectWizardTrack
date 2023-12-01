package com.example.wizardtrack.model.data


import java.math.BigDecimal


data class SaveCount(
    var id: Long = 0,
    var idUser: Long = 0,
    var amount: BigDecimal = BigDecimal.ZERO,
    var starDate: String  = "2000-01-01T00:00:00",
    var endDate: String  = "2000-01-01T00:00:00",
    var description: String? = null,
    var name: String = "",
    var idUserNavigation: UserWizardtrack? = null
)

package com.example.wizardtrack.model.data

data class UserWizardtrack(
    var id: Long = 0,
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var salt: ByteArray? = null,
    var debts: List<Debt> = mutableListOf(),
    var incomes: List<Income> = mutableListOf(),
    var saveCounts: List<SaveCount> = mutableListOf(),
    var spents: List<Spent> = mutableListOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserWizardtrack

        if (id != other.id) return false
        if (name != other.name) return false
        if (email != other.email) return false
        if (password != other.password) return false
        if (salt != null) {
            if (other.salt == null) return false
            if (!salt.contentEquals(other.salt)) return false
        } else if (other.salt != null) return false
        if (debts != other.debts) return false
        if (incomes != other.incomes) return false
        if (saveCounts != other.saveCounts) return false
        if (spents != other.spents) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + (salt?.contentHashCode() ?: 0)
        result = 31 * result + debts.hashCode()
        result = 31 * result + incomes.hashCode()
        result = 31 * result + saveCounts.hashCode()
        result = 31 * result + spents.hashCode()
        return result
    }
}

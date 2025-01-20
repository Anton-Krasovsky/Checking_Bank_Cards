package by.tigertosh.checking_bank_cards.domain.model

data class BinHistory(
    val id: Int = 0,
    val bin: String,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val bankName: String?,
    val countryName: String?
)

package by.tigertosh.checking_bank_cards.domain.model

data class BinHistory(
    val id: Int = 0,
    val bin: String,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val bankName: String?,
    val bankUrl: String?,
    val bankPhone: String?,
    val bankCity: String?,
    val countryName: String?,
    val countryEmoji: String?,
    val countryLatitude: Int?,
    val countryLongitude: Int?,
    val timestamp: Long = System.currentTimeMillis()
)

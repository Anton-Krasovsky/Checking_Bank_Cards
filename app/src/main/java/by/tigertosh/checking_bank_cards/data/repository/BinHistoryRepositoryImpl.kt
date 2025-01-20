package by.tigertosh.checking_bank_cards.data.repository

import by.tigertosh.checking_bank_cards.data.local.dao.BinHistoryDao
import by.tigertosh.checking_bank_cards.data.local.entity.BinHistoryEntity
import by.tigertosh.checking_bank_cards.data.remote.BinApiService
import by.tigertosh.checking_bank_cards.domain.model.BinHistory
import by.tigertosh.checking_bank_cards.domain.model.BinResponse
import by.tigertosh.checking_bank_cards.domain.repository.BinHistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BinHistoryRepositoryImpl @Inject constructor(
    private val dao: BinHistoryDao,
    private val apiService: BinApiService
) : BinHistoryRepository {

    override fun getBinHistory(): Flow<List<BinHistory>> {
        return dao.getAllBinHistory().map { entities ->
            entities.map { entity ->
                entity.toDomainModel()
            }
        }
    }

    override suspend fun saveBinHistory(binHistory: BinHistory) {
        dao.insertBinHistory(binHistory.toEntity())
    }

    override suspend fun fetchBinDetails(bin: String): BinResponse {
        return apiService.getBinDetails(bin).body()!!
    }
}

fun BinHistoryEntity.toDomainModel(): BinHistory {
    return BinHistory(
        id = id,
        bin = bin,
        scheme = scheme,
        type = type,
        brand = brand,
        bankName = bankName,
        bankUrl = bankUrl,
        bankPhone = bankPhone,
        bankCity = bankCity,
        countryName = countryName,
        countryEmoji = countryEmoji,
        countryLatitude = countryLatitude,
        countryLongitude = countryLongitude,
        timestamp = timestamp
    )
}

fun BinHistory.toEntity(): BinHistoryEntity {
    return BinHistoryEntity(
        id = id,
        bin = bin,
        scheme = scheme,
        type = type,
        brand = brand,
        bankName = bankName,
        bankUrl = bankUrl,
        bankPhone = bankPhone,
        bankCity = bankCity,
        countryName = countryName,
        countryEmoji = countryEmoji,
        countryLatitude = countryLatitude,
        countryLongitude = countryLongitude,
        timestamp = timestamp
    )
}
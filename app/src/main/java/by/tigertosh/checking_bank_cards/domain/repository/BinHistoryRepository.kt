package by.tigertosh.checking_bank_cards.domain.repository

import by.tigertosh.checking_bank_cards.data.local.dao.BinHistoryDao
import by.tigertosh.checking_bank_cards.data.local.entity.BinHistoryEntity
import by.tigertosh.checking_bank_cards.data.remote.BinApiService
import javax.inject.Inject

class BinHistoryRepository @Inject constructor(
    private val dao: BinHistoryDao,
    private val apiService: BinApiService
) {
    fun getBinHistory() = dao.getAllBinHistory()

    suspend fun saveBinHistory(binHistory: BinHistoryEntity) {
        dao.insertBinHistory(binHistory)
    }

    suspend fun fetchBinDetails(bin: String) = apiService.getBinDetails(bin)
}
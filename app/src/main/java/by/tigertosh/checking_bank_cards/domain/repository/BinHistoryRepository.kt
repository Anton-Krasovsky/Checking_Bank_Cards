package by.tigertosh.checking_bank_cards.domain.repository

import by.tigertosh.checking_bank_cards.domain.model.BinHistory
import by.tigertosh.checking_bank_cards.domain.model.BinResponse
import kotlinx.coroutines.flow.Flow

interface BinHistoryRepository {
    fun getBinHistory(): Flow<List<BinHistory>>
    suspend fun saveBinHistory(binHistory: BinHistory)
    suspend fun fetchBinDetails(bin: String): BinResponse
}
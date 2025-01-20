package by.tigertosh.checking_bank_cards.domain.usecase

import by.tigertosh.checking_bank_cards.domain.model.BinHistory
import by.tigertosh.checking_bank_cards.domain.repository.BinHistoryRepository
import javax.inject.Inject

class SaveBinHistoryUseCase @Inject constructor(
    private val repository: BinHistoryRepository
) {
    suspend operator fun invoke(binHistory: BinHistory) {
        repository.saveBinHistory(binHistory)
    }
}
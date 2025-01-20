package by.tigertosh.checking_bank_cards.domain.usecase

import by.tigertosh.checking_bank_cards.domain.model.BinHistory
import by.tigertosh.checking_bank_cards.domain.repository.BinHistoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBinHistoryUseCase @Inject constructor(
    private val repository: BinHistoryRepository
) {
    operator fun invoke(): Flow<List<BinHistory>> {
        return repository.getBinHistory()
    }
}
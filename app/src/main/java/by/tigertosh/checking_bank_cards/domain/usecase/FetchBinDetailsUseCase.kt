package by.tigertosh.checking_bank_cards.domain.usecase

import by.tigertosh.checking_bank_cards.domain.model.BinResponse
import by.tigertosh.checking_bank_cards.domain.repository.BinHistoryRepository
import javax.inject.Inject

class FetchBinDetailsUseCase @Inject constructor(
    private val repository: BinHistoryRepository
) {
    suspend operator fun invoke(bin: String): BinResponse {
        return repository.fetchBinDetails(bin)
    }
}
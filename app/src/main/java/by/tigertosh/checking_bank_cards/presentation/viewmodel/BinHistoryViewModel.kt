package by.tigertosh.checking_bank_cards.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.tigertosh.checking_bank_cards.domain.repository.BinHistoryRepository
import by.tigertosh.checking_bank_cards.data.local.entity.BinHistoryEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinHistoryViewModel @Inject constructor(
    private val repository: BinHistoryRepository
) : ViewModel() {

    val binHistory: StateFlow<List<BinHistoryEntity>> =
        repository.getBinHistory()
            .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun saveBinHistory(binHistory: BinHistoryEntity) {
        viewModelScope.launch {
            repository.saveBinHistory(binHistory)
        }
    }
}
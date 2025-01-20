package by.tigertosh.checking_bank_cards.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.tigertosh.checking_bank_cards.domain.model.BinHistory
import by.tigertosh.checking_bank_cards.domain.usecase.GetBinHistoryUseCase
import by.tigertosh.checking_bank_cards.domain.usecase.SaveBinHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinHistoryViewModel @Inject constructor(
    private val getBinHistoryUseCase: GetBinHistoryUseCase,
    private val saveBinHistoryUseCase: SaveBinHistoryUseCase
) : ViewModel() {

    val binHistory: StateFlow<List<BinHistory>> =
        getBinHistoryUseCase()
            .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun saveBinHistory(binHistory: BinHistory) {
        viewModelScope.launch {
            saveBinHistoryUseCase(binHistory)
        }
    }
}
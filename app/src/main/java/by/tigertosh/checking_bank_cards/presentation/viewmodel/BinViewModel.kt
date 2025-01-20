package by.tigertosh.checking_bank_cards.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.tigertosh.checking_bank_cards.domain.repository.BinHistoryRepository
import by.tigertosh.checking_bank_cards.domain.model.BinResponse
import by.tigertosh.checking_bank_cards.data.local.entity.BinHistoryEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinViewModel @Inject constructor(
    private val repository: BinHistoryRepository
) : ViewModel() {

    private val _binResponse = MutableStateFlow<BinResponse?>(null)
    val binResponse: StateFlow<BinResponse?> = _binResponse

    private val _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean> = _isError

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchBinDetails(bin: String) {
        viewModelScope.launch {
            try {
                val response = repository.fetchBinDetails(bin)
                if (response.isSuccessful) {
                    val binResponse = response.body()
                    _binResponse.value = binResponse
                    _isError.value = false
                    _errorMessage.value = null

                    if (binResponse != null) {
                        val binHistory = BinHistoryEntity(
                            bin = bin,
                            scheme = binResponse.scheme,
                            type = binResponse.type,
                            brand = binResponse.brand,
                            bankName = binResponse.bank?.name,
                            bankUrl = binResponse.bank?.url,
                            bankPhone = binResponse.bank?.phone,
                            bankCity = binResponse.bank?.city,
                            countryName = binResponse.country?.name,
                            countryEmoji = binResponse.country?.emoji,
                            countryLatitude = binResponse.country?.latitude,
                            countryLongitude = binResponse.country?.longitude
                        )
                        repository.saveBinHistory(binHistory)
                    }
                } else if (response.code() == 404) {
                    _binResponse.value = null
                    _isError.value = true
                    _errorMessage.value = "BIN не найден."
                } else {
                    _binResponse.value = null
                    _isError.value = true
                    _errorMessage.value = "Ошибка сервера: ${response.code()}."
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _binResponse.value = null
                _isError.value = true
                _errorMessage.value = "Ошибка подключения: ${e.message}."
            }
        }
    }

    fun setError(value: Boolean) {
        _isError.value = value
        _errorMessage.value = if (value) "BIN должен содержать 6 или 8 цифр" else null
    }
}
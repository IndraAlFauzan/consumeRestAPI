package com.example.consumeapi.ui.kontak.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumeapi.data.KontakRepository
import com.example.consumeapi.model.Kontak
import com.example.consumeapi.ui.kontak.screen.DetailsDestination
import kotlinx.coroutines.launch

sealed class DetaiksKontakUiState {
    data class Success(
        val kontak: Kontak) : DetaiksKontakUiState()

    object Error : DetaiksKontakUiState()
    object Loading : DetaiksKontakUiState()
}

class DetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val kontakRepository: KontakRepository
) : ViewModel() {


    private val kontakId: Int = checkNotNull(savedStateHandle[DetailsDestination.kontakId])
    var detailsKontakUiState: DetaiksKontakUiState by mutableStateOf(DetaiksKontakUiState.Loading)
        private set

    init {
        getKontakById()

    }
    fun getKontakById() {
        viewModelScope.launch {
            detailsKontakUiState = DetaiksKontakUiState.Loading
            detailsKontakUiState = try {
                DetaiksKontakUiState.Success(
                    kontak = kontakRepository.getKontakById(kontakId)
                )
            } catch (e: Exception) {
                DetaiksKontakUiState.Error
            }
        }

    }
}


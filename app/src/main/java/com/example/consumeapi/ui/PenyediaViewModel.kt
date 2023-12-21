package com.example.consumeapi.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.consumeapi.KontakAplikation
import com.example.consumeapi.ui.home.viewmodel.HomeViewModel
import com.example.consumeapi.ui.kontak.viewmodel.DetailsViewModel
import com.example.consumeapi.ui.kontak.viewmodel.InserViewModel


object PenyediaViewModel {
    val Factory = viewModelFactory {


        initializer {
            HomeViewModel(apkikasiKontak().container.kontakRepository)
        }

        initializer {
            InserViewModel(apkikasiKontak().container.kontakRepository)
        }

        initializer {
            DetailsViewModel(
                createSavedStateHandle(),
                kontakRepository = apkikasiKontak().container.kontakRepository
            )

        }

    }
}

fun CreationExtras.apkikasiKontak(): KontakAplikation =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KontakAplikation)
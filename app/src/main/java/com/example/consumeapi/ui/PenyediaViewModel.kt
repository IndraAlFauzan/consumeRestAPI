package com.example.consumeapi.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.consumeapi.KontakAplikation
import com.example.consumeapi.ui.home.viewmodel.HomeViewModel


object PenyediaViewModel {
    val Factory = viewModelFactory {

//        initializer {
//            MarsViewModel(apkikasiMars().container.marsPhotosRepository)
//        }
        initializer {
            HomeViewModel(apkikasiMars().container.kontakRepository)
        }

    }
}

fun CreationExtras.apkikasiMars(): KontakAplikation =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KontakAplikation)
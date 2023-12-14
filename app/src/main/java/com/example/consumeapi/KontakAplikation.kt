package com.example.consumeapi

import android.app.Application
import com.example.consumeapi.data.AppContainer
import com.example.consumeapi.data.KontakContainer

class KontakAplikation : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = KontakContainer()
    }
}
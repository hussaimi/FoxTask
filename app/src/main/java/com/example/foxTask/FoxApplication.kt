package com.example.foxTask

import android.app.Application
import com.example.foxTask.dagger.AppComponent
import com.example.foxTask.dagger.DaggerAppComponent

class FoxApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}
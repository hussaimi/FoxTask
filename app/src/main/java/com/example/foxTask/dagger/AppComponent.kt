package com.example.foxTask.dagger

import com.example.foxTask.view.activity.MainActivity
import com.example.foxTask.dagger.module.FoxFeedModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        FoxFeedModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)
}
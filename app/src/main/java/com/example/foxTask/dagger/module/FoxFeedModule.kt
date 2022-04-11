package com.example.foxTask.dagger.module

import com.example.foxTask.service.MockClient
import dagger.Module
import dagger.Provides

@Module
object FoxFeedModule {
    @Provides
    fun mockClient() = MockClient
}
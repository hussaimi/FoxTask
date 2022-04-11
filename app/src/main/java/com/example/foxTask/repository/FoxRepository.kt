package com.example.foxTask.repository

import com.example.foxTask.data.FeedItem
import com.example.foxTask.service.MockClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FoxRepository @Inject constructor(
    private val mockClient: MockClient
) {
    /*
    * Loading FeedItem from mockClient asynchronously
    */
    suspend fun getFeed(): List<FeedItem> {
        return withContext(Dispatchers.IO) {
            this.let {
                mockClient.getFeed()
            }
        }
    }
}
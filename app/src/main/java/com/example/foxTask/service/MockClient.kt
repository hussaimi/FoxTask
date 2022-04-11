package com.example.foxTask.service

import android.util.Log
import com.example.foxTask.data.Component
import com.example.foxTask.data.FeedItem
import kotlin.random.Random

object MockClient {
    fun getFeed() = buildFeed()
    private fun buildFeed(): List<FeedItem> {
        val items = mutableListOf<FeedItem>()
        Component.values().forEach {
            val max = Random.nextInt(1, 11)
            for (i in 0..max) {
                val item = FeedItem(it, "Headline #${i + 1} for $it", null)
                items.add(item)
            }
        }
        Log.d("Items: ", items.toString())
        return items
    }
}
package com.example.foxTask.repository

import com.example.foxTask.data.Component
import com.example.foxTask.data.FeedItem
import com.example.foxTask.service.MockClient
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FoxRepositoryTest {

    @MockK
    lateinit var mockClient: MockClient

    private lateinit var foxRepository: FoxRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        every { mockClient.getFeed() } returns listOf(
            FeedItem(Component.BIG_TOP, "Testing Feed 1", null),
            FeedItem(Component.AD, "Testing Feed 2", null)
        )
        foxRepository = FoxRepository(mockClient)
    }

    @Test
    fun testGetFeed() {
        runBlocking {
            val feedList = foxRepository.getFeed()
            verify { mockClient.getFeed() }
            assertEquals(2, feedList.size)
            assertEquals(Component.BIG_TOP, feedList[0].component)
            assertEquals("Testing Feed 1", feedList[0].headline)
            assertEquals(Component.AD, feedList[1].component)
            assertEquals("Testing Feed 2", feedList[1].headline)
        }
    }
}
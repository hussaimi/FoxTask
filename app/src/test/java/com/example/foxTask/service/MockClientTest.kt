package com.example.foxTask.service

import org.junit.Assert.assertTrue
import org.junit.Test

class MockClientTest {

    private lateinit var mockClient: MockClient

    @Test
    fun mockClientGetFeed() {
        mockClient = MockClient
        val feedList = mockClient.getFeed()
        val listBigTop = feedList.filter { it.component.name == "BIG_TOP" }
        val listRiver = feedList.filter { it.component.name == "RIVER" }
        val listAd = feedList.filter { it.component.name == "AD" }
        val listHouseAd = feedList.filter { it.component.name == "HOUSE_AD" }
        val listSlideShow = feedList.filter { it.component.name == "SLIDE_SHOW" }

        assertTrue(listBigTop.isNotEmpty())
        assertTrue(listRiver.isNotEmpty())
        assertTrue(listAd.isNotEmpty())
        assertTrue(listHouseAd.isNotEmpty())
        assertTrue(listSlideShow.isNotEmpty())
    }
}
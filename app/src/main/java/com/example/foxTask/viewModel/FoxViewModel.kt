package com.example.foxTask.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foxTask.data.FeedItem
import com.example.foxTask.repository.FoxRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class FoxViewModel @Inject constructor(
    private val repository: FoxRepository
) : ViewModel() {

    var feedLiveData: MutableLiveData<List<FeedItem>> = MutableLiveData()

    fun getFeed() {
        viewModelScope.launch {
            feedLiveData.postValue(repository.getFeed())
        }
    }

}
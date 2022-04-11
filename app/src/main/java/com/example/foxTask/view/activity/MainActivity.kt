package com.example.foxTask.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foxTask.FoxApplication
import com.example.foxTask.view.adapter.RecyclerViewAdapter
import com.example.foxTask.databinding.ActivityMainBinding
import com.example.foxTask.viewModel.FoxViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var foxViewModel: FoxViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as FoxApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initializing recyclerViewAdapter
        val recyclerViewAdapter = RecyclerViewAdapter()
        binding.foxFeedList.adapter = recyclerViewAdapter

        // Implementing pull to refresh
        binding.swipeToRefresh.setOnRefreshListener {
            foxViewModel.getFeed()
        }

        //Observing feedLiveData for any change
        foxViewModel.feedLiveData.observe(this) {
            binding.swipeToRefresh.isRefreshing = false
            recyclerViewAdapter.setFeedItemList(it)
        }
        foxViewModel.getFeed()
    }
}
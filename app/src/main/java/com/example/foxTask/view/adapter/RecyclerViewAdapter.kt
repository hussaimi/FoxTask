package com.example.foxTask.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foxTask.data.FeedItem
import com.example.foxTask.databinding.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var feedItemList: List<FeedItem> = emptyList()

    override fun getItemViewType(position: Int): Int {
        return feedItemList[position].component.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> BigTopViewHolder(
                FeedItemBigTopBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            1 -> RiverViewHolder(
                FeedItemRiverBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            2 -> AdViewHolder(
                FeedItemAdBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            3 -> HouseAdViewHolder(
                FeedItemHouseAdBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> SlideShowViewHolder(
                FeedItemSlideShowBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feedItem = feedItemList[position]
        when (feedItem.component.ordinal) {
            0 -> (holder as BigTopViewHolder).binding.headline.text = feedItem.headline
            1 -> (holder as RiverViewHolder).binding.headline.text = feedItem.headline
            2 -> (holder as AdViewHolder).binding.headline.text = feedItem.headline
            3 -> (holder as HouseAdViewHolder).binding.headline.text = feedItem.headline
            else -> (holder as SlideShowViewHolder).binding.headline.text = feedItem.headline
        }
    }

    override fun getItemCount(): Int {
        return feedItemList.size
    }

    fun setFeedItemList(feedItem: List<FeedItem>) {
        feedItemList = feedItem
        notifyDataSetChanged()
    }

    class BigTopViewHolder(val binding: FeedItemBigTopBinding) :
        RecyclerView.ViewHolder(binding.root)

    class RiverViewHolder(val binding: FeedItemRiverBinding) :
        RecyclerView.ViewHolder(binding.root)

    class AdViewHolder(val binding: FeedItemAdBinding) :
        RecyclerView.ViewHolder(binding.root)

    class HouseAdViewHolder(val binding: FeedItemHouseAdBinding) :
        RecyclerView.ViewHolder(binding.root)

    class SlideShowViewHolder(val binding: FeedItemSlideShowBinding) :
        RecyclerView.ViewHolder(binding.root)
}
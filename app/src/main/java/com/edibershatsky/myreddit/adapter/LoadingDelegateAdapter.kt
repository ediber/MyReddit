package com.edibershatsky.myreddit.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.droidcba.kedditbysteps.commons.inflate
import com.edibershatsky.myreddit.R


class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {
    }
}
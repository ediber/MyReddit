package com.edibershatsky.myreddit.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by Edi Bershatsky on 08/11/2017.
 */
class NewsAdapter(listener: NewsDelegateAdapter.onViewSelectedListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    private val loadingItem = object : ViewType {
        override fun getViewType() : Int {
            return AdapterConstants.LOADING
        }
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.NEWS, NewsDelegateAdapter(listener))

        items = java.util.ArrayList()

        val news = mutableListOf<RedditNewsItem>()
        for (i in 1..10) {
            news.add(RedditNewsItem("author "+i, "title "+1, i, i.toLong(), "image", "http://www.iconarchive.com/show/futurama-icons-by-pixelpirate/URL-icon.html"))
        }
        items.addAll(news)
        items.add(loadingItem)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
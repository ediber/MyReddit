package com.edibershatsky.myreddit.adapter

/**
 * Created by Edi Bershatsky on 09/11/2017.
 */

class RedditNewsItem(var author: String?,
                     var title: String?,
                     val numComments: Int,
                     val created: Long,
                     val thumbnail: String,
                     val url: String?) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS

}
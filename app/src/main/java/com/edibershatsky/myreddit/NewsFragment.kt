package com.edibershatsky.myreddit

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.recyclerview.R.attr.layoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.droidcba.kedditbysteps.commons.inflate
import com.edibershatsky.myreddit.adapter.NewsAdapter
import com.edibershatsky.myreddit.adapter.NewsDelegateAdapter
import kotlinx.android.synthetic.main.news_fragment.*

class NewsFragment : Fragment(), NewsDelegateAdapter.onViewSelectedListener {



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // extention function
        val view =  container?.inflate(R.layout.news_fragment)

        // old way
       /* var newsList = view?.findViewById<RecyclerView>(R.id.news_list)
        newsList?.setHasFixedSize(true) // use this setting to improve performance
        newsList?.layoutManager = LinearLayoutManager(context)*/

        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.apply {
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            clearOnScrollListeners()
//            addOnScrollListener(InfiniteScrollListener({ requestNews() }, linearLayout))
        }

        news_list.adapter = NewsAdapter(this)
    }

    override fun onItemSelected(url: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}// Required empty public constructor

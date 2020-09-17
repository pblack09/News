package com.example.newsapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.newsapp.R
import com.example.newsapp.adapters.AdapterNews
import com.example.newsapp.models.Article
import com.example.newsapp.models.News
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_layout.view.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    var mList: ArrayList<Article> = ArrayList()
    var myAdapter: AdapterNews? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        getData()
        myAdapter = AdapterNews(this, mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = myAdapter
    }

    private fun getData(){
        val url = "http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=a1c63f6fa6a645088799c895f54f5ed6"
        var requestData = Volley.newRequestQueue(this)
        var request = StringRequest(
            Request.Method.GET,
            url,
            {
                var gson = Gson()
                var newsResult = gson.fromJson(it, News::class.java)
                mList.addAll(newsResult.articles)
                myAdapter?.setData(mList)
                progress_bar.visibility = View.GONE
            },
            {
                Log.d("abc", it.toString())
            }
        )
        requestData.add(request)
    }

}
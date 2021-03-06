package com.example.newsapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.activities.CommonActivity
import com.example.newsapp.models.Article
import kotlinx.android.synthetic.main.row_layout.view.*

class AdapterNews(var mContext: Context, var mList: ArrayList<Article>) : RecyclerView.Adapter<AdapterNews.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNews.ViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterNews.ViewHolder, position: Int) {
        var article = mList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(l: ArrayList<Article>){
        mList = l
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article){
            itemView.row_title.text = article.title
            itemView.row_description.text = article.description
            itemView.row_author.text = article.author

            itemView.setOnClickListener{
                val intent = Intent(mContext, CommonActivity::class.java).apply{
                    putExtra("TITLE", article.title)
                    putExtra("ARTICLE", article.content)
                    putExtra("AUTHOR", article.author)
                    putExtra("IMAGE", article.urlToImage)
                    putExtra("SOURCE", article.url)
                }
                mContext.startActivity(intent)
            }
        }
    }

}
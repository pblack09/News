package com.example.newsapp.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.net.toUri
import com.example.newsapp.R
import kotlinx.android.synthetic.main.activity_common.*
import java.net.URI

class CommonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        init()
    }

    private fun init() {
        val title = intent.getStringExtra("TITLE")
        val article = intent.getStringExtra("ARTICLE")
        val author = intent.getStringExtra("AUTHOR")
        val imageUrl = intent.getStringExtra("IMAGE")
        val source = intent.getStringExtra("SOURCE")

        val uri = Uri.parse(imageUrl)

        article_title.text = title
        article_author.text = author
        article_contents.text = article
        article_image.setImageURI(uri)
        article_source.text = source

        button_back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
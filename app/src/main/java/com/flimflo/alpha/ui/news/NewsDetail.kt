package com.flimflo.alpha.ui.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flimflo.alpha.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val bundle=intent.extras

        if(bundle != null) {
            txtDateNewsDetail.text = bundle.getString(NewsConstants.DATE)
            Picasso.with(this).load(bundle.getString(NewsConstants.IMAGE)).fit().centerInside().into(imgNewsDetail)
            txtTitleNewsDetail.text = bundle.getString(NewsConstants.TITLE)
            txtContentNewsDetail.text = bundle.getString(NewsConstants.DESCRIPTION)
        }
    }
}
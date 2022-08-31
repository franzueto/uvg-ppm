package com.franzueto.lab1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class DisplayMessageActivity : AppCompatActivity() {

    companion object {
        const val PI = 3.14
        const val KEY_EXTRA_TEXT = "KEY_EXTRA_TEXT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val message = intent.getStringExtra(KEY_EXTRA_TEXT)
        //val textView = findViewById<TextView>(R.id.messageTextView)
        //textView.text = message

        findViewById<TextView>(R.id.messageTextView).apply {
            text = message
        }

        val imageView = findViewById<ImageView>(R.id.imageView2)
        Picasso.get()
            .load("https://i.imgur.com/DvpvklR.png")
            .resize(200,200)
            //.centerCrop()
            .centerInside()
            .placeholder(R.drawable.dice_1)
            .error(R.drawable.dice_6)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                    // no-op
                }

                override fun onError(e: Exception?) {
                    e?.printStackTrace()
                }

            })


//        Glide.with(this)
//            .load("http://goo.gl/gEgYUd")
//            .placeholder(R.drawable.dice_1)
//            .centerCrop()
//            .into(imageView)
    }
}
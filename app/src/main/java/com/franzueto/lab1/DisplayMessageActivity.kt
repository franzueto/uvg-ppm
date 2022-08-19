package com.franzueto.lab1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayMessageActivity : AppCompatActivity() {

    companion object {
        const val PI = 3.14
        const val MESSAGE_KEY = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val message = intent.getStringExtra(MESSAGE_KEY)
        //val textView = findViewById<TextView>(R.id.messageTextView)
        //textView.text = message

        findViewById<TextView>(R.id.messageTextView).apply {
            text = message
        }
    }
}
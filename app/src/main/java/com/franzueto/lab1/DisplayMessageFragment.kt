package com.franzueto.lab1

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class DisplayMessageFragment : Fragment(R.layout.activity_display_message) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val message = intent.getStringExtra(DisplayMessageActivity.KEY_EXTRA_TEXT)

        view.findViewById<TextView>(R.id.messageTextView).apply {
            text = "TODO: obtain the message as an argument."
        }
    }
}
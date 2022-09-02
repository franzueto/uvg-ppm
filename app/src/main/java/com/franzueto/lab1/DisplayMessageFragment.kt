package com.franzueto.lab1

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class DisplayMessageFragment : Fragment(R.layout.activity_display_message) {

    val arg: DisplayMessageFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val message = intent.getStringExtra(DisplayMessageActivity.KEY_EXTRA_TEXT)

        view.findViewById<TextView>(R.id.messageTextView).apply {
            text = arg.message
        }
    }
}
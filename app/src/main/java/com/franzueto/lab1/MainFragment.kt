package com.franzueto.lab1

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val editText = view.findViewById<EditText>(R.id.editTextTextPersonName)
            val message = editText.text.toString()

            val title = "Compartir"

            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(DisplayMessageActivity.KEY_EXTRA_TEXT, message)
                type = "text/plain"
            }

            val chooser: Intent = Intent.createChooser(intent, title)
            if (intent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(chooser)
            }

//            try {
//                startActivity(intent)
//            } catch (e: ActivityNotFoundException) {
//                e.printStackTrace()
//            }
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }
}
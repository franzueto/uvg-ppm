package com.franzueto.lab1

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val editText = view.findViewById<EditText>(R.id.editTextTextPersonName)
            val message = editText.text.toString()

            val action = MainFragmentDirections.actionMainFragmentToDisplayMessageFragment(message)

            findNavController().navigate(action)
        }
    }
}
package com.franzueto.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment = MainFragment()

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, fragment)
            }
        }

//        val button = findViewById<Button>(R.id.button)
//
//        button.setOnClickListener {
//            val editText = findViewById<EditText>(R.id.editTextTextPersonName)
//            val message = editText.text.toString()
//            val intent = Intent(this, DisplayMessageActivity::class.java).apply {
//                putExtra(DisplayMessageActivity.MESSAGE_KEY, message)
//            }
//            startActivity(intent)
//        }
    }
}
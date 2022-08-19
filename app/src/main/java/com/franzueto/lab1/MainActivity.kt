package com.franzueto.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        const val MESSAGE_KEY = "MESSAGE_KEY"
    }

    var message: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            message = it.getString(MESSAGE_KEY)
        }

        message?.let {
            sayHi(it)
        }

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val editText = findViewById<EditText>(R.id.editTextTextPersonName)
            val message = editText.text.toString()
            sayHi(message)
            this.message = message
//            val intent = Intent(this, DisplayMessageActivity::class.java).apply {
//                putExtra(DisplayMessageActivity.MESSAGE_KEY, message)
//            }
//            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(MESSAGE_KEY, message)
    }

    private fun sayHi(message: String) {
        val hiMessage = getString(R.string.say_hi)
        findViewById<TextView>(R.id.textView).text = "$hiMessage $message"
    }
}
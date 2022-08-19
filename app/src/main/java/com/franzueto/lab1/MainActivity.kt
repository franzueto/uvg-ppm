package com.franzueto.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        const val DEBUG_TAG = "DEBUG_TAG"
        const val KEY_MESSAGE = "KEY_MESSAGE"
    }

    var message: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(DEBUG_TAG, "onCreate()")
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        savedInstanceState?.let { bundle ->
            message = bundle.getString(KEY_MESSAGE)
            message?.let {
                sayHi(it)
            }
        }

        button.setOnClickListener {
            val editText = findViewById<EditText>(R.id.editTextTextPersonName)
            val message = editText.text.toString()

            this.message = message
            sayHi(message)
        }
    }

    private fun sayHi(message: String)  {
        findViewById<TextView>(R.id.textView).text = getString(R.string.say_hi) + " " + message
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(DEBUG_TAG, "onSaveInstanceState()")
        outState.putString(KEY_MESSAGE, message)
    }

    override fun onStart() {
        super.onStart()
        Log.i(DEBUG_TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(DEBUG_TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(DEBUG_TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(DEBUG_TAG, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(DEBUG_TAG, "onDestroy()")
    }
}
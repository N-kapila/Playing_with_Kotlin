package com.example.practiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i("MYTAG", "SecondActivity : OneCreate")
        val userName = intent.getStringExtra("USER")
        val textView = findViewById<TextView>(R.id.tvOffer)
        val message = "$userName, You will get offer"
        textView.text = message
    }
    override fun onStart() {
        super.onStart()
        Log.i("MYTAG", "SecondActivity : OneStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG", "SecondActivity : OneResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG", "SecondActivity : OnePause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAG", "SecondActivity : OneStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAG", "SecondActivity : OneDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MYTAG", "SecondActivity : OneReStart")
    }
}
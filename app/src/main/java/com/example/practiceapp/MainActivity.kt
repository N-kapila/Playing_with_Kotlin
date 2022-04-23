package com.example.practiceapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var nameText : EditText
    private lateinit var sf : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameText = findViewById(R.id.etName)
        sf =getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sf.edit()

        Log.i("MYTAG", "MainActivity : OneCreate")
        val greetingTextView = findViewById<TextView>(R.id.tvHello)
        val inputField = findViewById<EditText>(R.id.etName)
        val submitButton = findViewById<Button>(R.id.btnSubmit)
        val offersButton = findViewById<Button>(R.id.btnOffers)
        var enteredName = ""
        submitButton.setOnClickListener{
            enteredName = inputField.text.toString()
            if (enteredName == ""){
                offersButton.visibility = INVISIBLE
                greetingTextView.text = ""
                Toast.makeText(
                    this@MainActivity,
                    "Please enter your name!",
                    Toast.LENGTH_SHORT
                ).show()
            }else {
                val message = "Welcome $enteredName !"
                greetingTextView.text = message
                inputField.text.clear()
                offersButton.visibility = VISIBLE
            }
        }
        offersButton.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("USER",enteredName)
            startActivity(intent)
        }
    }

//    override fun onPause(){
//        super.onPause()
//        val name =nameText.text.toString()
//        editor.apply(){
//            putString("sf_name",name)
//            commit()
//        }
//    }

    override fun onStart() {
        super.onStart()
        Log.i("MYTAG", "MainActivity : OneStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG", "MainActivity : OneResume")
        val name = sf.getString("sf_name",null)
        nameText.setText(name)
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG", "MainActivity : OnePause")
        val name =nameText.text.toString()
        editor.apply(){
            putString("sf_name",name)
            commit()
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAG", "MainActivity : OneStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAG", "MainActivity : OneDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MYTAG", "MainActivity : OneReStart")
    }
}
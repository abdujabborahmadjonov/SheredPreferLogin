package com.example.myappsharedpreference

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myappsharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerMe.setOnClickListener {
            Toast.makeText(this,"entered",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }

        binding.login.setOnClickListener {

            val user: String = binding.textUsername.text.toString()
            val password: String = binding.textPassword.text.toString()
            val preferences: SharedPreferences = getSharedPreferences("MYPREFS", MODE_PRIVATE)
            val userDetails: String? = preferences.getString(user + password , "Username or Password is Incorrect.")
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.putString("display", userDetails)
            editor.apply()
            val displayScreen = Intent(this@MainActivity, DisplayScreen::class.java)
            startActivity(displayScreen)
        }
        binding.registerMe.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

    }

}


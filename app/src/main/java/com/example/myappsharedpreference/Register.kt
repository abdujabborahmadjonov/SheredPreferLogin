package com.example.myappsharedpreference

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myappsharedpreference.databinding.RegisterBinding

class Register : AppCompatActivity() {
    lateinit var binding: RegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.register.setOnClickListener {
            val preferences: SharedPreferences = getSharedPreferences("MYPREFS", MODE_PRIVATE)
            val newUser: String = binding.userName.getText().toString()
            val newPassword: String = binding.password.getText().toString()
            val newEmail: String = binding.email.getText().toString()
            val editor: SharedPreferences.Editor = preferences.edit()


            editor.putString(newUser + newPassword ,newUser + "\n" + newEmail)
            editor.commit()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.backToLogin.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
    }


}
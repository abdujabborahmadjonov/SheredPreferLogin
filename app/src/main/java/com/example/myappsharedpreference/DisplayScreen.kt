package com.example.myappsharedpreference

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myappsharedpreference.databinding.ActivityStarterBinding
import com.example.myappsharedpreference.databinding.DisplayInfoBinding

class DisplayScreen: AppCompatActivity() {
    lateinit var binding: DisplayInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DisplayInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences: SharedPreferences = getSharedPreferences("MYPREFS", MODE_PRIVATE)
        val display: String? = preferences.getString("display", "")
        binding.display.text = display
    }
}
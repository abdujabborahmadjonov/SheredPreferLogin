package com.example.myappsharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.myappsharedpreference.databinding.ActivityStarterBinding

class StarterActivity : AppCompatActivity() {
    lateinit var binding: ActivityStarterBinding
    lateinit var frombottom: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStarterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loginbtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        binding.registerbtn.setOnClickListener {
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }

        binding.bgApp.animate().translationY(-1200F).setDuration(3000).setStartDelay(300)
        binding.cloverimg.animate().alpha(0F).setDuration(3000).setStartDelay(600)
        binding.splashtext.animate().translationY(140f).alpha(0f).setDuration(1800).setStartDelay(300)

        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom)
        binding.menus.startAnimation(frombottom)

        binding.hometxt.startAnimation(frombottom)
    }
}
package com.min0.ssogong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.min0.ssogong.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MainActivity1::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.mapbtn.setOnClickListener {
            startActivity(intent)
        }

    }
}
package com.min0.ssogong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.min0.ssogong.databinding.ActivityMainBinding
import com.naver.maps.map.MapView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.mapbtn.setOnClickListener {
            // 버튼 클릭 시 MyMapViewActivity 시작
            val intent = Intent(this, Map::class.java)
            startActivity(intent)
        }
    }
}

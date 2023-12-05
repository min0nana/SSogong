package com.min0.ssogong

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import kotlin.collections.Map
import kotlin.concurrent.timer
class TimerNFee : AppCompatActivity() {
    private var time = 0
    private var timerTask: Timer?= null

    private lateinit var timeText: TextView
    private lateinit var retbtn: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeText = findViewById(R.id.timeText)
        retbtn = findViewById(R.id.retbtn)

        startTimer()

        retbtn.setOnClickListener{
            stopTimer()
            val intent = Intent(this, Map::class.java)
            startActivity(intent)
        }
    }
    private fun startTimer() {
        timerTask = timer(period = 10) {
            time++
            val min = time / 6000
            val sec = (time % 6000) / 100

            val timeString = String.format("%02d:%02d", min, sec)

            runOnUiThread {
                timeText.text = timeString
            }
        }
    }

    //타이머 스톱
    private fun stopTimer() {
        timerTask?.cancel()
    }

    //현재 시간
    private fun currentTime() {
        val currentTime: Long = System.currentTimeMillis() // ms로 반환
        println(currentTime)

        val dataFormat1 = SimpleDateFormat("yyyy-MM-dd") // 년 월 일
        val dataFormat2 = SimpleDateFormat("yy-MM-dd-E") // 년(20XX) 월 일 요일
        val dataFormat3 = SimpleDateFormat("hh:mm:ss") // 시(1~12) 분 초
        val dataFormat4 = SimpleDateFormat("HH:mm:ss") // 시(0~23) 분 초
        val dataFormat5 = SimpleDateFormat("현재시각은 \nyyyy-MM-dd \nhh:mm:ss")
    }



}
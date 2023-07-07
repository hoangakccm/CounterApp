package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ToggleButton
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var numberTv : TextView
    private lateinit var startStop : ToggleButton
    private  var second =0
    private var  isTimerStarted = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initUIEvenHanders()
    }

    private fun initUIEvenHanders() {
        startStop.setOnCheckedChangeListener { _, isChecked ->
           if(isChecked){
               isTimerStarted = true
               Thread {
                   while (isTimerStarted){
                       second++
                       runOnUiThread {
                           numberTv.text ="$second"
                       }
                       Thread.sleep(1000)
                   }
               }.start()

           }else{
               isTimerStarted = false
           }
        }
    }

    private fun initView() {
        numberTv = findViewById(R.id.number_tv)
        startStop = findViewById(R.id.start_stop)
    }
}
package com.elevenetc.android.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abc.HelloClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        HelloClass().hello()
    }
}
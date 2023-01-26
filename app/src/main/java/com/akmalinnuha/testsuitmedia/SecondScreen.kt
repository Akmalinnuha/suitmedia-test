package com.akmalinnuha.testsuitmedia

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondScreen : AppCompatActivity() {
    private lateinit var helloName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        helloName = findViewById(R.id.myName)
        val btnUser = findViewById<Button>(R.id.chooseUser)
        btnUser.setOnClickListener {
            val moveToThirdScreen = Intent(this@SecondScreen, ThirdScreen::class.java)
            startActivity(moveToThirdScreen)
        }
    }

    override fun onResume() {
        super.onResume()
        val penyimpanan: SharedPreferences = getSharedPreferences("storage", AppCompatActivity.MODE_PRIVATE)
        if (penyimpanan.getString("aran","") != null){
            helloName.text = penyimpanan.getString("aran", "")
        }
    }
}
package com.akmalinnuha.testsuitmedia

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var txtName: EditText
    private lateinit var txtPalindrome: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMain()
        val btnPalindrome = findViewById<Button>(R.id.btnCheck)
        btnPalindrome.setOnClickListener {
            if (isPalindrome(txtPalindrome.text.toString())) {
                Toast.makeText(this, "It is palindrome", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "It is not palindrome", Toast.LENGTH_SHORT).show()
            }
        }

        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            val penyimpanan: SharedPreferences = getSharedPreferences("storage", AppCompatActivity.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = penyimpanan.edit()
            if (txtName.text.isNotEmpty()){
                editor.putString("aran", txtName.text.toString())
                editor.apply()
                val move = Intent(this@MainActivity, SecondScreen::class.java)
                startActivity(move)
            } else {
                Toast.makeText(this, "Please enter the name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isPalindrome(inputStr: String): Boolean {
        val sb = StringBuilder(inputStr)

        //reverse the string
        val reverseStr = sb.reverse().toString()

        //compare reversed string with input string
        return inputStr.equals(reverseStr, ignoreCase = true)
    }

    fun initMain() {
        txtName = findViewById(R.id.name)
        txtPalindrome = findViewById(R.id.palindrome)
    }
}
package com.example.final_ema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        initEvents() //Llamado al cambio de activity
    }

    fun initEvents(){           // Funcion que permite transportarnos de una activity a otra
        val button = findViewById<Button>(R.id.Btnback)
        button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java) //Vuelve Main
            startActivity(intent)
        }
    }
}

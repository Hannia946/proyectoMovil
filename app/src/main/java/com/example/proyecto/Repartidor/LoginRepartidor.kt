package com.example.proyecto.Repartidor

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto.R

class LoginRepartidor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_repartidor)

        val registrar = findViewById<TextView>(R.id.tvRegistrarR)
        registrar.setOnClickListener {
            val intent = Intent(this, RegistroRepartidor::class.java)
            startActivity(intent)
        }
    }
}








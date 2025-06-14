package com.example.proyecto.Repartidor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto.R

class LoginRepartidor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_repartidor)

        val etEmailR = findViewById<EditText>(R.id.etEmailR)
        val etPasswordR = findViewById<EditText>(R.id.etPasswordR)
        val btnLoginR = findViewById<Button>(R.id.btnLoginR)
        val registrar = findViewById<TextView>(R.id.tvRegistrarR)

        val sharedPreferences = getSharedPreferences("RepartidorPrefs", MODE_PRIVATE)

        btnLoginR.setOnClickListener {
            val email = etEmailR.text.toString().trim()
            val password = etPasswordR.text.toString()

            val savedEmail = sharedPreferences.getString("email", null)
            val savedPassword = sharedPreferences.getString("password", null)

            if (email == savedEmail && password == savedPassword) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, RepartidorHomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        registrar.setOnClickListener {
            val intent = Intent(this, RegistroRepartidor::class.java)
            startActivity(intent)
        }
    }
}





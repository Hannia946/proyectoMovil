package com.example.proyecto.cliente

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto.R

class LoginClienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_cliente)

        val etEmailC = findViewById<EditText>(R.id.etEmail)
        val etPasswordC = findViewById<EditText>(R.id.etPassword)
        val btnLoginC = findViewById<Button>(R.id.btnLoginC)
        val registrar = findViewById<TextView>(R.id.tvRegistrarC)

        val sharedPreferences = getSharedPreferences("ClientePrefs", MODE_PRIVATE)

        btnLoginC.setOnClickListener {
            val email = etEmailC.text.toString().trim()
            val password = etPasswordC.text.toString()

            val savedEmail = sharedPreferences.getString("email", null)
            val savedPassword = sharedPreferences.getString("password", null)

            if (email == savedEmail && password == savedPassword) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivityCliente::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        registrar.setOnClickListener {
            val intent = Intent(this, RegistroClienteActivity::class.java)
            startActivity(intent)
        }

    }
}
package com.example.proyecto.Repartidor

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto.R

class RegistroRepartidor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_registro_repartidor)

        val nombre = findViewById<EditText>(R.id.etNombresR)
        val apellido = findViewById<EditText>(R.id.etApellidosR)
        val telefono = findViewById<EditText>(R.id.etTelefonoR)
        val email = findViewById<EditText>(R.id.etEmailR)
        val password = findViewById<EditText>(R.id.etPasswordR)
        val rPassword = findViewById<EditText>(R.id.etRPassword)
        val botonRegistrar = findViewById<com.google.android.material.button.MaterialButton>(R.id.btnRegistrarR)

        val sharedPreferences = getSharedPreferences("RepartidorPrefs", MODE_PRIVATE)

        botonRegistrar.setOnClickListener {
            val nom = nombre.text.toString().trim()
            val ape = apellido.text.toString().trim()
            val tel = telefono.text.toString().trim()
            val mail = email.text.toString().trim()
            val pass = password.text.toString()
            val rpass = rPassword.text.toString()

            if (nom.isEmpty() || ape.isEmpty() || tel.isEmpty() || mail.isEmpty() || pass.isEmpty() || rpass.isEmpty()) {
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pass != rpass) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //Guardar los datos
            val editor = sharedPreferences.edit()
            editor.putString("email", mail)
            editor.putString("password", pass)
            editor.apply()

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, LoginRepartidor::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}

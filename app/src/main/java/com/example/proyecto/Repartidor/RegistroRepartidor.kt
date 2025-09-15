package com.example.proyecto.Repartidor

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
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

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val view = currentFocus
            if (view is EditText) {
                val outRect = Rect()
                view.getGlobalVisibleRect(outRect)
                if (!outRect.contains(ev.rawX.toInt(), ev.rawY.toInt())) {
                    view.clearFocus()
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}

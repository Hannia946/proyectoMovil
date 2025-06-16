package com.example.proyecto.cliente

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
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

        //activa flecha pa ir atrás
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed() // Para API modernas
        return true
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
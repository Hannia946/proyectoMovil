package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        verBienvenida()
    }

    private fun verBienvenida(){
        object : CountDownTimer (5000,100 ){

            override fun onTick(millisUntilFinished: Long) {

            }
            override fun onFinish() {
                startActivity(Intent(this@SplashScreenActivity, SeleccionarTipoActivity::class.java))
                finishAffinity()
            }

        }.start()
    }
}